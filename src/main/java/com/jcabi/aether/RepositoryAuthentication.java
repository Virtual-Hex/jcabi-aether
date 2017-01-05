/**
 * Copyright (c) 2012-2017, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.aether;

import com.jcabi.aspects.Immutable;
import org.sonatype.aether.repository.Authentication;

/**
 * Parameter holder for org.sonatype.aether.repository.Authentication.
 *
 * @author Mauricio Herrera (oruam85@gmail.com)
 * @version $Id$
 */
@Immutable
public final class RepositoryAuthentication {

    /**
     * The user name.
     */
    private final transient String username;

    /**
     * The password.
     */
    @Immutable.Array
    private final transient char[] password;

    /**
     * The path to the private key file.
     */
    private final transient String privatekeyfile;

    /**
     * The passphrase for the private key file.
     */
    @Immutable.Array
    private final transient char[] passphrase;

    /**
     * Creates a new authentication with the specified properties.
     * @param auth The authentication object.
     */
    @SuppressWarnings("PMD.NullAssignment")
    public RepositoryAuthentication(final Authentication auth) {
        this.username = auth.getUsername();
        if (auth.getPassword() == null) {
            this.password = null;
        } else {
            this.password = auth.getPassword().toCharArray();
        }
        this.privatekeyfile = auth.getPrivateKeyFile();
        if (auth.getPassphrase() == null) {
            this.passphrase = null;
        } else {
            this.passphrase = auth.getPassphrase().toCharArray();
        }
    }

    /**
     * Get the Authentication object.
     * @return The Authentication object.
     */
    public Authentication getAuthentication() {
        return new Authentication(
            this.username,
            this.password,
            this.privatekeyfile,
            this.passphrase
        );
    }
}
