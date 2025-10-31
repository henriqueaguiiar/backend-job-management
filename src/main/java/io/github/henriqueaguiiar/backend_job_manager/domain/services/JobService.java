package io.github.henriqueaguiiar.backend_job_manager.domain.services;


import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Job;
import org.springframework.stereotype.Service;

@Service
public interface JobService {

    void createJob(Job job);
}
