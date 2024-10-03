package org.parker.client;

import org.parker.Response;

public interface Session {
    Response authenticate(String username, String password);
}
