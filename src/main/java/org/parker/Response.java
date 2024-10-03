package org.parker;

public interface Response {
    enum AuthenticationFailure implements Response{
        InvalidPassword,
        UnknownUser,
    }
    enum SessionFailure implements Response{
        TooManyAttempts,
    }
    enum AuthenticationSuccess implements Response{
        Success
    }
    enum InvalidRequest implements Response{
        MalformedPassword,
        MalformedUsername,
    }
}
