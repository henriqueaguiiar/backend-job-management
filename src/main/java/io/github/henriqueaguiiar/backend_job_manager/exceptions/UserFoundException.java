package io.github.henriqueaguiiar.backend_job_manager.exceptions;




public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    }
}
