package io.github.henriqueaguiiar.backend_job_manager.exceptions;

public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(){
        super("User not found");
    }


}
