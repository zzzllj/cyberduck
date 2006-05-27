package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.*;

import com.apple.cocoa.application.*;
import com.apple.cocoa.foundation.*;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * @version $Id$
 */
public abstract class CDBrowserTableDataSource extends CDController {
    protected static Logger log = Logger.getLogger(CDBrowserTableDataSource.class);

    protected static final NSImage SYMLINK_ICON = NSImage.imageNamed("symlink.tiff");
    protected static final NSImage FOLDER_ICON = NSImage.imageNamed("folder16.tiff");
    protected static final NSImage FOLDER_NOACCESS_ICON = NSImage.imageNamed("folder_noaccess.tiff");
    protected static final NSImage FOLDER_WRITEONLY_ICON = NSImage.imageNamed("folder_writeonly.tiff");
    protected static final NSImage NOT_FOUND_ICON = NSImage.imageNamed("notfound.tiff");

    public static final String TYPE_COLUMN = "TYPE";
    public static final String FILENAME_COLUMN = "FILENAME";
    public static final String SIZE_COLUMN = "SIZE";
    public static final String MODIFIED_COLUMN = "MODIFIED";
    public static final String OWNER_COLUMN = "OWNER";
    public static final String PERMISSIONS_COLUMN = "PERMISSIONS";
    // virtual column to implement keyboard selection
    protected static final String TYPEAHEAD_COLUMN = "TYPEAHEAD";

    /**
     * Must be efficient; called very frequently by the table view
     *
     * @param path The directory to fetch the childs from
     * @return The cached or newly fetched file listing of the directory
     */
    protected List childs(Path path) {
        List childs = null;
        if(controller.isConnected()) {
            childs = path.list(controller.getComparator(), controller.getFileFilter());
        }
        else {
            childs = controller.getSession().cache().get(path, controller.getComparator(), controller.getFileFilter());
        }
        if(null == childs) {
            return new ArrayList();
        }
        return childs;
    }

    protected CDBrowserController controller;

    public CDBrowserTableDataSource(CDBrowserController controller) {
        this.controller = controller;
    }

    public int indexOf(NSView tableView, Path p) {
        return this.childs(controller.workdir()).indexOf(p);
    }

    public boolean contains(NSView tableView, Path p) {
        return this.childs(controller.workdir()).contains(p);
    }

    public void setObjectValueForItem(final Path item, final Object value, final String identifier) {
        log.debug("setObjectValueForItem:" + item);
        if (identifier.equals(FILENAME_COLUMN)) {
            if (!item.getName().equals(value) && !value.equals("")) {
                controller.invoke(new Runnable() {
                    public void run() {
                        Path renamed = PathFactory.createPath(controller.workdir().getSession(),
                                item.getParent().getAbsolute(), value.toString());
                        controller.renamePath(item, renamed);
                        item.getParent().invalidate();
                        controller.reloadData(false);
                        controller.setSelectedPath(renamed);
                    }
                });
            }
        }
    }

    public Object objectValueForItem(Path item, String identifier) {
        if (null != item) {
            if (identifier.equals(TYPE_COLUMN)) {
                NSImage icon;
                if (item.attributes.isSymbolicLink()) {
                    icon = SYMLINK_ICON;
                }
                else if (item.attributes.isDirectory()) {
                    icon = FOLDER_ICON;
					if (!item.attributes.isExecutable()) {
						icon = FOLDER_NOACCESS_ICON;
					}
                    else if (!item.attributes.isReadable()) {
                        if (item.attributes.isWritable()) {
                            icon = FOLDER_WRITEONLY_ICON;
                        }
                    }
                }
                else if (item.attributes.isFile()) {
                    icon = CDIconCache.instance().get(item.getExtension());
                }
                else {
                    icon = NOT_FOUND_ICON;
                }
                icon.setSize(new NSSize(16f, 16f));
                return icon;
            }
            if (identifier.equals(FILENAME_COLUMN)) {
                return new NSAttributedString(item.getName(), CDTableCell.PARAGRAPH_DICTIONARY_LEFT_ALIGNEMENT);
            }
            if (identifier.equals(TYPEAHEAD_COLUMN)) {
                return item.getName();
            }
            if (identifier.equals(SIZE_COLUMN)) {
                return new NSAttributedString(Status.getSizeAsString(item.attributes.getSize()),
                        CDTableCell.PARAGRAPH_DICTIONARY_RIGHHT_ALIGNEMENT);
            }
            if (identifier.equals(MODIFIED_COLUMN)) {
                if (item.attributes.getTimestamp() != -1) {
                    return new NSGregorianDate((double) item.attributes.getTimestamp() / 1000,
                            NSDate.DateFor1970);
                }
                return null;
            }
            if (identifier.equals(OWNER_COLUMN)) {
                return new NSAttributedString(item.attributes.getOwner(),
                        CDTableCell.PARAGRAPH_DICTIONARY_LEFT_ALIGNEMENT);
            }
            if (identifier.equals(PERMISSIONS_COLUMN)) {
                return new NSAttributedString(item.attributes.getPermission().toString(),
                        CDTableCell.PARAGRAPH_DICTIONARY_LEFT_ALIGNEMENT);
            }
            throw new IllegalArgumentException("Unknown identifier: " + identifier);
        }
		log.warn("objectValueForItem:"+item+","+identifier);
        return null;
    }

    // ----------------------------------------------------------
    //	NSDraggingSource
    // ----------------------------------------------------------

    public boolean ignoreModifierKeysWhileDragging() {
        return false;
    }

    public int draggingSourceOperationMaskForLocal(boolean local) {
        log.debug("draggingSourceOperationMaskForLocal:" + local);
        if (local)
            return NSDraggingInfo.DragOperationMove | NSDraggingInfo.DragOperationCopy;
        return NSDraggingInfo.DragOperationCopy;
    }

    public boolean acceptDrop(NSTableView view, Path destination, NSDraggingInfo info) {
        log.debug("acceptDrop:" + destination);
        if (info.draggingPasteboard().availableTypeFromArray(new NSArray(NSPasteboard.FilenamesPboardType)) != null) {
            Object o = info.draggingPasteboard().propertyListForType(NSPasteboard.FilenamesPboardType);
            if (o != null) {
                NSArray elements = (NSArray) o;
                final Queue q = new UploadQueue();
                Session session = (Session)controller.workdir().getSession().clone();
                for (int i = 0; i < elements.count(); i++) {
                    Path p = PathFactory.createPath(session,
                            destination.getAbsolute(),
                            new Local((String) elements.objectAtIndex(i)));
                    q.addRoot(p);
                }
                if (q.numberOfRoots() > 0) {
                    CDQueueController.instance().startItem(q);
                    q.addListener(new QueueAdapter() {
                        public void queueStopped() {
                            if (controller.isMounted()) {
                                controller.workdir().getSession().cache().invalidate(q.getRoot().getParent());
                                controller.reloadData(true);
                            }
                            q.removeListener(this);
                        }
                    });
                }
            }
            return true;
        }
        if (NSPasteboard.pasteboardWithName("QueuePBoard").availableTypeFromArray(new NSArray("QueuePBoardType")) != null) {
            Object o = NSPasteboard.pasteboardWithName("QueuePBoard").propertyListForType("QueuePBoardType");
            if (o != null) {
                NSArray elements = (NSArray) o;
                List selected = new ArrayList();
                for (int i = 0; i < elements.count(); i++) {
                    NSDictionary dict = (NSDictionary) elements.objectAtIndex(i);
                    Queue q = QueueFactory.createQueue(dict);
                    for (Iterator iter = q.getRoots().iterator(); iter.hasNext();) {
                        Path current = PathFactory.createPath(controller.workdir().getSession(),
                                ((Path) iter.next()).getAbsolute());
                        Path renamed = PathFactory.createPath(controller.workdir().getSession(),
                                destination.getAbsolute(), current.getName());
                        controller.renamePath(current, renamed);
                        if(!controller.isConnected()) {
                            break;
                        }
                        selected.add(renamed);
                    }
                }
                destination.invalidate();
                controller.reloadData(true);
                controller.setSelectedPaths(selected);
                NSPasteboard.pasteboardWithName("QueuePBoard").setPropertyListForType(null, "QueuePBoardType");
                return true;
            }
        }
        return false;

    }

    public int validateDrop(NSTableView view, Path destination, int row, NSDraggingInfo info) {
        if (controller.isMounted()) {
            if (info.draggingPasteboard().availableTypeFromArray(new NSArray(NSPasteboard.FilenamesPboardType)) != null) {
                if (destination.equals(controller.workdir())) {
                    view.setDropRowAndDropOperation(-1, NSTableView.DropOn);
                    return NSDraggingInfo.DragOperationCopy;
                }
                if (destination.attributes.isDirectory()) {
                    view.setDropRowAndDropOperation(row, NSTableView.DropOn);
                    return NSDraggingInfo.DragOperationCopy;
                }
            }
            NSPasteboard pboard = NSPasteboard.pasteboardWithName("QueuePBoard");
            if (pboard.availableTypeFromArray(new NSArray("QueuePBoardType")) != null) {
                Object o = pboard.propertyListForType("QueuePBoardType");
                if (o != null) {
                    NSArray elements = (NSArray) o;
                    for (int i = 0; i < elements.count(); i++) {
                        NSDictionary dict = (NSDictionary) elements.objectAtIndex(i);
                        Queue q = QueueFactory.createQueue(dict);
                        for (Iterator iter = q.getRoots().iterator(); iter.hasNext();) {
                            Path item = (Path) iter.next();
                            if(!item.getSession().equals(this.controller.getSession())) {
                                return NSDraggingInfo.DragOperationNone;
                            }
                            if (destination.equals(item)) {
                                return NSDraggingInfo.DragOperationNone;
                            }
                            if (item.attributes.isDirectory() && destination.isChild(item)) {
                                return NSDraggingInfo.DragOperationNone;
                            }
                            if (item.getParent().equals(destination)) {
                                return NSDraggingInfo.DragOperationNone;
                            }
                        }
                    }
                    if (destination.equals(controller.workdir())) {
                        view.setDropRowAndDropOperation(-1, NSTableView.DropOn);
                        return NSDraggingInfo.DragOperationMove;
                    }
                    if (destination.attributes.isDirectory()) {
                        view.setDropRowAndDropOperation(row, NSTableView.DropOn);
                        return NSDraggingInfo.DragOperationMove;
                    }
                }
            }
        }
        return NSDraggingInfo.DragOperationNone;
    }

    /**
     * The files dragged from the browser to the Finder
     */
    private Path[] promisedDragPaths;

    public boolean writeItemsToPasteBoard(NSTableView view, NSArray items, NSPasteboard pboard) {
        if (controller.isMounted()) {
            if (items.count() > 0) {
                this.promisedDragPaths = new Path[items.count()];
                // The fileTypes argument is the list of fileTypes being promised. The array elements can consist of file extensions and HFS types encoded with the NSHFSFileTypes method fileTypeForHFSTypeCode. If promising a directory of files, only include the top directory in the array.
                NSMutableArray fileTypes = new NSMutableArray();
                Queue q = new DownloadQueue();
                Session session = (Session)controller.workdir().getSession().clone();
                for (int i = 0; i < items.count(); i++) {
                    promisedDragPaths[i] = (Path)((Path) items.objectAtIndex(i)).clone(session);
                    if (promisedDragPaths[i].attributes.isFile()) {
                        if (promisedDragPaths[i].getExtension() != null) {
                            fileTypes.addObject(promisedDragPaths[i].getExtension());
                        }
                        else {
                            fileTypes.addObject(NSPathUtilities.FileTypeRegular);
                        }
                    }
                    else if (promisedDragPaths[i].attributes.isDirectory()) {
                        fileTypes.addObject("'fldr'");
                    }
                    else {
                        fileTypes.addObject(NSPathUtilities.FileTypeUnknown);
                    }
                    q.addRoot(promisedDragPaths[i]);
                }

                // Writing data for private use when the item gets dragged to the transfer queue.
                NSPasteboard queuePboard = NSPasteboard.pasteboardWithName("QueuePBoard");
                queuePboard.declareTypes(new NSArray("QueuePBoardType"), null);
                if (queuePboard.setPropertyListForType(new NSArray(q.getAsDictionary()), "QueuePBoardType")) {
                    log.debug("QueuePBoardType data sucessfully written to pasteboard");
                }

                NSEvent event = NSApplication.sharedApplication().currentEvent();
                NSPoint dragPosition = view.convertPointFromView(event.locationInWindow(), null);
                NSRect imageRect = new NSRect(new NSPoint(dragPosition.x() - 16, dragPosition.y() - 16), new NSSize(32, 32));
                view.dragPromisedFilesOfTypes(fileTypes, imageRect, this, true, event);
                // @see http://www.cocoabuilder.com/archive/message/cocoa/2003/5/15/81424
                return true;
            }
        }
        return false;
    }

    //see http://www.cocoabuilder.com/archive/message/2005/10/5/118857
    public void finishedDraggingImage(NSImage image, NSPoint point, int operation) {
        log.debug("finishedDraggingImage:" + operation);
        this.promisedDragPaths = null;
    }

    /**
     * @return the names (not full paths) of the files that the receiver promises to create at dropDestination.
     * This method is invoked when the drop has been accepted by the destination and the destination, in the case of another
     * Cocoa application, invokes the NSDraggingInfo method namesOfPromisedFilesDroppedAtDestination. For long operations,
     * you can cache dropDestination and defer the creation of the files until the finishedDraggingImage method to avoid
     * blocking the destination application.
     */
    public NSArray namesOfPromisedFilesDroppedAtDestination(java.net.URL dropDestination) {
        log.debug("namesOfPromisedFilesDroppedAtDestination:" + dropDestination);
        NSMutableArray promisedDragNames = new NSMutableArray();
        if (null != dropDestination) {
            for (int i = 0; i < this.promisedDragPaths.length; i++) {
                try {
                    this.promisedDragPaths[i].setLocal(new Local(java.net.URLDecoder.decode(dropDestination.getPath(), "UTF-8"),
                            this.promisedDragPaths[i].getName()));
                }
                catch (UnsupportedEncodingException e) {
                    log.error(e.getMessage());
                }
                promisedDragNames.addObject(this.promisedDragPaths[i].getName());
            }
        }
        if (this.promisedDragPaths.length == 1) {
            if (this.promisedDragPaths[0].attributes.isFile()) {
                this.promisedDragPaths[0].getLocal().createNewFile();
            }
            if (this.promisedDragPaths[0].attributes.isDirectory()) {
                this.promisedDragPaths[0].getLocal().mkdir();
            }
        }
        this.invoke(new Runnable() {
            public void run() {
                Queue q = new DownloadQueue();
                for (int i = 0; i < promisedDragPaths.length; i++) {
                    q.addRoot(promisedDragPaths[i]);
                }
                if (q.numberOfRoots() > 0) {
                    CDQueueController.instance().startItem(q);
                }
            }
        });
        return promisedDragNames;
    }

    protected void finalize() throws java.lang.Throwable {
        log.debug("finalize:"+this.toString());
        super.finalize();
    }
}