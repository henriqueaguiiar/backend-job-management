package io.github.henriqueaguiiar.backend_job_manager.domain.services.exception;

public class CompanyFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CompanyFoundException() {
        super("Company already exists");
    }
}
