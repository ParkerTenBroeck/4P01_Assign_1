package org.parker.server;

import org.parker.Response;

public class ClientSession {
    private final Server server;
    public ClientSession(Server server){
        this.server = server;
    }
    public Response authenticate(String username, String password){
        return server.authenticate(username, password);
    }
}
