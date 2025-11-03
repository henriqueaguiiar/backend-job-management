package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;


import io.github.henriqueaguiiar.backend_job_manager.modules.entities.JobEntity;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    private final JobRepository jobRepository;

    @Autowired
    public ListAllJobsByFilterUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobEntity> execute(String filter){
      return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
