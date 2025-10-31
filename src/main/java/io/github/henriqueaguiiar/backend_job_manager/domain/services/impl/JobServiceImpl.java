package io.github.henriqueaguiiar.backend_job_manager.domain.services.impl;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Job;
import io.github.henriqueaguiiar.backend_job_manager.domain.repository.JobRepository;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }
}
