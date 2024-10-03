package org.parker.server;

import org.parker.Response;

public class ClientSession {
    private int unsuccessfulAttempts = 0;
    private final Server server;
    public ClientSession(Server server){
        this.server = server;
    }
    public Response authenticate(String username, String password){
        if (username == null) return Response.InvalidRequest.InvalidRequest;
        if (password == null) return Response.InvalidRequest.InvalidRequest;
        if (username.isBlank()) return Response.InvalidRequest.InvalidRequest;
        if (password.isBlank()) return Response.InvalidRequest.InvalidRequest;

        if (unsuccessfulAttempts >= 3){
            return Response.SessionFailure.TooManyAttempts;
        }
        var response = server.authenticate(username, password);
        unsuccessfulAttempts += 1;
        if (response == Response.Success.Success){
            unsuccessfulAttempts = 0;
        }
        return response;
    }
}
