package org.parker;

public interface Response {
    enum AccountFailure implements Response{
        InvalidPassword,
        UnknownUser,
    }
    enum SessionFailure implements Response{
        TooManyAttempts,
    }
    enum Success implements Response{
        Success
    }

    enum InvalidRequest {
        InvalidRequest
    }
}
