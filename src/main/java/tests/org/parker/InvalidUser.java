package tests.org.parker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.parker.Response;
import org.parker.server.ClientSession;
import org.parker.server.Server;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidUser {
    Server server;
    org.parker.client.Session session;

    @BeforeEach
    void setUp() {
        server = new Server((username, password) -> {
            if (!username.equals("Bob")){
                return Response.AccountFailure.UnknownUser;
            }else if (!password.equals("supersecret")){
                return Response.AccountFailure.InvalidPassword;
            }else{
                return Response.Success.Success;
            }
        });
        session = new ClientSession(server)::authenticate;
    }

    @Test
    void testInvalidUser() {
        assertEquals(
                Response.AccountFailure.UnknownUser,
                session.authenticate("Hello", "supersecret")
        );
        assertEquals(
                Response.AccountFailure.UnknownUser,
                session.authenticate("Alice", "supersecret")
        );
    }
}
