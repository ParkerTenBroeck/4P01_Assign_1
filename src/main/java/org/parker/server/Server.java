package org.parker.server;

import org.parker.Response;

public class Server {
    private final CredentialsVerifier credentialStore;
    public Server(CredentialsVerifier credentialStore){
        this.credentialStore = credentialStore;
    }
    public Response authenticate(String username, String password){
        return credentialStore.authenticate(username, password);
    }

}
