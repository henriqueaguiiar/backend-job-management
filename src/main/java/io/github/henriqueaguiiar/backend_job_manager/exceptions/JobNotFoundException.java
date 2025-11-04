package io.github.henriqueaguiiar.backend_job_manager.exceptions;

public class JobNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public JobNotFoundException(){
        super("Job not found");
    }


}
