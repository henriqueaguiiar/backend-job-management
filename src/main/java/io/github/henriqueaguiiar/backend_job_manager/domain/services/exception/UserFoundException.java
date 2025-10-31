package io.github.henriqueaguiiar.backend_job_manager.domain.services.exception;

public class UserFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserFoundException() {
        super("User already exists");
    }
}
