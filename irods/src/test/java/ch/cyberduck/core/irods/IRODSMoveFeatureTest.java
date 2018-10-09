package ch.cyberduck.core.irods;

/*
 * Copyright (c) 2002-2015 David Kocher. All rights reserved.
 * http://cyberduck.ch/
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
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DisabledCancelCallback;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledHostKeyCallback;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.DisabledPasswordStore;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Profile;
import ch.cyberduck.core.ProtocolFactory;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.serializer.impl.dd.ProfilePlistReader;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class IRODSMoveFeatureTest {

    @Test
    public void testMoveDirectory() throws Exception {
        final ProtocolFactory factory = new ProtocolFactory(new HashSet<>(Collections.singleton(new IRODSProtocol())));
        final Profile profile = new ProfilePlistReader(factory).read(
                new Local("../profiles/iRODS (iPlant Collaborative).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials(
                System.getProperties().getProperty("irods.key"), System.getProperties().getProperty("irods.secret")
        ));

        final IRODSSession session = new IRODSSession(host);
        session.open(new DisabledHostKeyCallback(), new DisabledLoginCallback());
        session.login(new DisabledPasswordStore(), new DisabledLoginCallback(), new DisabledCancelCallback());

        final Path source = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        final Path destination = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        new IRODSDirectoryFeature(session).mkdir(source, null, new TransferStatus());
        final String filename = new AlphanumericRandomStringService().random();
        new IRODSTouchFeature(session).touch(new Path(source, filename, EnumSet.of(Path.Type.file)), new TransferStatus());
        assertTrue(session.getFeature(Find.class).find(new Path(source, filename, EnumSet.of(Path.Type.file)), new DisabledListProgressListener()));
        new IRODSDirectoryFeature(session).mkdir(destination, null, new TransferStatus());
        new IRODSMoveFeature(session).move(source, destination, new TransferStatus().exists(true), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertFalse(session.getFeature(Find.class).find(source, new DisabledListProgressListener()));
        assertFalse(session.getFeature(Find.class).find(new Path(source, filename, EnumSet.of(Path.Type.file)), new DisabledListProgressListener()));
        assertTrue(session.getFeature(Find.class).find(destination, new DisabledListProgressListener()));
        assertTrue(session.getFeature(Find.class).find(new Path(destination, filename, EnumSet.of(Path.Type.file)), new DisabledListProgressListener()));
        session.getFeature(Delete.class).delete(Collections.singletonList(destination), new DisabledLoginCallback(), new Delete.DisabledCallback());
        assertFalse(session.getFeature(Find.class).find(destination, new DisabledListProgressListener()));
        session.close();
    }

    @Test
    public void testMoveFile() throws Exception {
        final ProtocolFactory factory = new ProtocolFactory(new HashSet<>(Collections.singleton(new IRODSProtocol())));
        final Profile profile = new ProfilePlistReader(factory).read(
                new Local("../profiles/iRODS (iPlant Collaborative).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials(
                System.getProperties().getProperty("irods.key"), System.getProperties().getProperty("irods.secret")
        ));

        final IRODSSession session = new IRODSSession(host);
        session.open(new DisabledHostKeyCallback(), new DisabledLoginCallback());
        session.login(new DisabledPasswordStore(), new DisabledLoginCallback(), new DisabledCancelCallback());

        final Path source = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        final Path destination = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        new IRODSTouchFeature(session).touch(source, new TransferStatus());
        new IRODSTouchFeature(session).touch(destination, new TransferStatus());
        new IRODSMoveFeature(session).move(source, destination, new TransferStatus().exists(true), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertFalse(session.getFeature(Find.class).find(source, new DisabledListProgressListener()));
        assertTrue(session.getFeature(Find.class).find(destination, new DisabledListProgressListener()));
        session.getFeature(Delete.class).delete(Collections.singletonList(destination), new DisabledLoginCallback(), new Delete.DisabledCallback());
        assertFalse(session.getFeature(Find.class).find(destination, new DisabledListProgressListener()));
        session.close();
    }

    @Test(expected = NotfoundException.class)
    public void testMoveNotFound() throws Exception {
        final ProtocolFactory factory = new ProtocolFactory(new HashSet<>(Collections.singleton(new IRODSProtocol())));
        final Profile profile = new ProfilePlistReader(factory).read(
                new Local("../profiles/iRODS (iPlant Collaborative).cyberduckprofile"));
        final Host host = new Host(profile, profile.getDefaultHostname(), new Credentials(
                System.getProperties().getProperty("irods.key"), System.getProperties().getProperty("irods.secret")
        ));

        final IRODSSession session = new IRODSSession(host);
        session.open(new DisabledHostKeyCallback(), new DisabledLoginCallback());
        session.login(new DisabledPasswordStore(), new DisabledLoginCallback(), new DisabledCancelCallback());

        final Path source = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        final Path destination = new Path(new IRODSHomeFinderService(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        assertFalse(session.getFeature(Find.class).find(source, new DisabledListProgressListener()));
        assertFalse(session.getFeature(Find.class).find(destination, new DisabledListProgressListener()));

        new IRODSMoveFeature(session).move(source, destination, new TransferStatus(), new Delete.DisabledCallback(), new DisabledConnectionCallback());
    }
}
