package tests.org.parker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.parker.Response;
import org.parker.server.ClientSession;
import org.parker.server.Server;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessAuth {
    Server server;
    org.parker.client.Session session;

    @BeforeEach
    void setUp() {
        server = new Server((username, password) -> {
            if (!username.equals("Bob")){
                return Response.AuthenticationFailure.UnknownUser;
            }else if (!password.equals("supersecret")){
                return Response.AuthenticationFailure.InvalidPassword;
            }else{
                return Response.AuthenticationSuccess.Success;
            }
        });
        session = new ClientSession(server)::authenticate;
    }

    @Test
    void testSuccessfulAuth() {
        assertEquals(
                Response.AuthenticationSuccess.Success,
                session.authenticate("Bob", "supersecret")
        );
    }
}
