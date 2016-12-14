package ch.cyberduck.core.cryptomator;

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

import ch.cyberduck.core.DescriptiveUrlBag;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.UrlProvider;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Vault;
import ch.cyberduck.core.vault.DecryptingListProgressListener;

import org.apache.log4j.Logger;

public class CryptoUrlProvider implements UrlProvider {
    private static final Logger log = Logger.getLogger(DecryptingListProgressListener.class);

    private final Session<?> session;
    private final UrlProvider delegate;
    private final Vault vault;

    public CryptoUrlProvider(final Session<?> session, final UrlProvider delegate, final Vault vault) {
        this.session = session;
        this.delegate = delegate;
        this.vault = vault;
    }

    @Override
    public DescriptiveUrlBag toUrl(final Path file) {
        try {
            return delegate.toUrl(vault.encrypt(session, file));
        }
        catch(BackgroundException e) {
            log.warn(String.format("Failure encrypting filename. %s", e.getMessage()));
            return DescriptiveUrlBag.empty();
        }
    }
}