package ch.cyberduck.core.googledrive;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.shared.DefaultHomeFinderService;

import java.util.EnumSet;

public class DriveHomeFinderService extends DefaultHomeFinderService {

    public static final String ROOT_FOLDER_ID = "root";

    public static final Path MYDRIVE_FOLDER
        = new Path(LocaleFactory.localizedString("My Drive", "Google Drive"),
        EnumSet.of(Path.Type.directory, Path.Type.placeholder, Path.Type.volume), new PathAttributes().withVersionId(ROOT_FOLDER_ID));

    public static final Path SHARED_FOLDER_NAME
        = new Path(LocaleFactory.localizedString("Shared with me", "Google Drive"),
        EnumSet.of(Path.Type.directory, Path.Type.placeholder, Path.Type.volume));

    public static final Path TEAM_DRIVES_NAME
        = new Path(LocaleFactory.localizedString("Team Drives", "Google Drive"),
        EnumSet.of(Path.Type.directory, Path.Type.placeholder, Path.Type.volume));

    public DriveHomeFinderService(final DriveSession session) {
        super(session);
    }

    @Override
    public Path find() throws BackgroundException {
        final Path home = super.find();
        if(home.isRoot()) {
            return MYDRIVE_FOLDER;
        }
        return home;
    }

    @Override
    public Path find(final Path root, final String path) {
        final Path home = super.find(root, path);
        if(home.isRoot()) {
            return MYDRIVE_FOLDER;
        }
        return home;
    }
}
