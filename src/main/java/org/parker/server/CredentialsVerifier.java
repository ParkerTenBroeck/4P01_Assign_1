package org.parker.server;

import org.parker.Response;

public interface CredentialsVerifier {
    Response authenticate(String username, String password);
}
