package ch.cyberduck.core.onedrive;/*
 * Copyright (c) 2002-2020 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.test.IntegrationTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.EnumSet;

import static ch.cyberduck.core.Path.Type;
import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class SharepointContainerServiceTest {
    private static SharepointContainerService containerService;

    @BeforeClass
    public static void setup() {
        containerService = new SharepointContainerService();
    }

    @Test
    public void testRoot() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        assertTrue(containerService.isContainer(root));
        final Path container = containerService.getContainer(root);
        assertEquals(root, container);
    }

    @Test
    public void testSites() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        assertFalse(containerService.isContainer(sites));
        final Path container = containerService.getContainer(sites);
        assertEquals(root, container);
    }

    @Test
    public void testSubsite() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        final Path site = new Path(sites, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("SITE-ID"));
        assertTrue(containerService.isContainer(site));
        final Path container = containerService.getContainer(site);
        assertEquals(site, container);
    }

    @Test
    public void testSiteSites() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        final Path site = new Path(sites, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("SITE-ID"));
        final Path sites2 = new Path(site, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        assertFalse(containerService.isContainer(sites2));
        final Path container = containerService.getContainer(sites2);
        assertEquals(site, container);
    }

    @Test
    public void testSiteDrives() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        final Path site = new Path(sites, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("SITE-ID"));
        final Path drives = new Path(site, "Drives", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.DRIVES_NAME.attributes()));
        assertFalse(containerService.isContainer(drives));
        final Path container = containerService.getContainer(drives);
        assertEquals(site, container);
    }

    @Test
    public void testDrive() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        final Path site = new Path(sites, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("SITE-ID"));
        final Path drives = new Path(site, "Drives", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.DRIVES_NAME.attributes()));
        final Path drive = new Path(drives, "Drive", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("DRIVE-ID"));
        assertTrue(containerService.isContainer(drive));
        final Path container = containerService.getContainer(drive);
        assertEquals(drive, container);
    }

    @Test
    public void testDriveFolder() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path sites = new Path(root, "Sites", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.SITES_NAME.attributes()));
        final Path site = new Path(sites, "Site", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("SITE-ID"));
        final Path drives = new Path(site, "Drives", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.DRIVES_NAME.attributes()));
        final Path drive = new Path(drives, "Drive", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("DRIVE-ID"));
        final Path folder = new Path(drive, "Folder", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("FOLDER-ID"));
        assertFalse(containerService.isContainer(folder));
        final Path container = containerService.getContainer(folder);
        assertEquals(drive, container);
    }

    @Test
    public void testGroups() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path groups = new Path(root, "Groups", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.GROUPS_NAME.attributes()));
        assertFalse(containerService.isContainer(groups));
        final Path container = containerService.getContainer(groups);
        assertEquals(root, container);
    }

    @Test
    public void testGroup() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path groups = new Path(root, "Groups", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.GROUPS_NAME.attributes()));
        final Path group = new Path(groups, "Group", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("GROUP-NAME"));
        assertTrue(containerService.isContainer(group));
        final Path container = containerService.getContainer(group);
        assertEquals(group, container);
    }

    @Test
    public void testGroupDrives() {
        final Path root = new Path("/", EnumSet.of(Type.directory));
        final Path groups = new Path(root, "Groups", EnumSet.of(Type.directory)).withAttributes(new PathAttributes(SharepointListService.GROUPS_NAME.attributes()));
        final Path group = new Path(groups, "Group", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("GROUP-NAME"));
        final Path drive = new Path(group, "Documents", EnumSet.of(Type.directory)).withAttributes(new PathAttributes().withVersionId("Documents"));
        assertTrue(containerService.isContainer(drive));
        final Path container = containerService.getContainer(drive);
        assertEquals(drive, container);
    }

    @Test
    public void testGroupsWithoutVersionId() {
        final Path drive = new Path("/Groups/Group/Documents", EnumSet.of(Type.directory));
        final Path groupsFolder = new Path(drive, "Groups", EnumSet.of(Type.directory));
        final Path groupFolder = new Path(groupsFolder, "Group", EnumSet.of(Type.directory));
        final Path testFolder = new Path(groupFolder, "testFolder", EnumSet.of(Type.directory));
        final Path test = new Path(testFolder, "Ensure-PreviousIsSet", EnumSet.of(Type.directory));
        assertFalse(containerService.isContainer(test));
        final Path container = containerService.getContainer(test);
        assertEquals(drive, container);
    }
}
