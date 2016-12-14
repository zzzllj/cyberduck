package ch.cyberduck.core.vault;

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

import ch.cyberduck.core.ListService;
import ch.cyberduck.core.PasswordCallback;
import ch.cyberduck.core.PasswordStore;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Vault;

public class LookupVault implements Vault {
    private final PasswordStore keychain;
    private final PasswordCallback prompt;
    private final VaultLookupListener listener;

    public LookupVault(final PasswordStore keychain, final PasswordCallback prompt, final VaultLookupListener listener) {
        this.keychain = keychain;
        this.prompt = prompt;
        this.listener = listener;
    }

    @Override
    public Vault create(final Session<?> session, final String region) throws BackgroundException {
        return this;
    }

    @Override
    public Vault load(final Session<?> session) throws BackgroundException {
        return this;
    }

    @Override
    public void close() {
        //
    }

    @Override
    public boolean contains(final Path file) {
        return false;
    }

    @Override
    public Path encrypt(final Session<?> session, final Path file) throws BackgroundException {
        return file;
    }

    @Override
    public Path encrypt(final Session<?> session, final Path file, final boolean metadata) throws BackgroundException {
        return file;
    }

    @Override
    public Path decrypt(final Session<?> session, final Path directory, final Path file) throws BackgroundException {
        return file;
    }

    @Override
    public long toCiphertextSize(final long cleartextFileSize) {
        return 0L;
    }

    @Override
    public long toCleartextSize(final long ciphertextFileSize) {
        return 0L;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getFeature(final Session<?> session, final Class<T> type, final T delegate) {
        if(type == ListService.class) {
            return (T) new VaultFinderListService(this, session, session, new VaultFinderListProgressListener(session, keychain, prompt, listener));
        }
        return delegate;
    }

}