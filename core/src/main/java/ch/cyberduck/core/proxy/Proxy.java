package ch.cyberduck.core.proxy;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
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
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import org.apache.commons.lang3.StringUtils;

public final class Proxy {

    public enum Type {
        /**
         * Represents a direct connection, or the absence of a proxy.
         */
        DIRECT,
        HTTP,
        HTTPS,
        /**
         * Represents a SOCKS (V4 or V5) proxy.
         */
        SOCKS
    }

    private final Type type;
    private String hostname;
    private int port;
    private String userinfo;

    private Proxy(final Type type) {
        this.type = type;
    }

    public Proxy(final Type type, final String hostname, final int port) {
        this.type = type;
        this.hostname = hostname;
        this.port = port;
    }

    public Proxy(final Type type, final String hostname, final int port, final String userinfo) {
        this.type = type;
        this.hostname = hostname;
        this.port = port;
        this.userinfo = userinfo;
    }

    public Type getType() {
        return type;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public String getUser() {
        if(StringUtils.contains(userinfo, ':')) {
            return StringUtils.split(userinfo, ':')[0];
        }
        return null;
    }

    public String getPassword() {
        if(StringUtils.contains(userinfo, ':')) {
            return StringUtils.split(userinfo, ':')[1];
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proxy{");
        sb.append("type=").append(type);
        sb.append(", hostname='").append(hostname).append('\'');
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }

    public static final Proxy DIRECT = new Proxy(Type.DIRECT);
}
