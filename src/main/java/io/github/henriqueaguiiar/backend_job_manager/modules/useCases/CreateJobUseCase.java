package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;

import io.github.henriqueaguiiar.backend_job_manager.exceptions.CompanyNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.modules.entities.JobEntity;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CompanyRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {


    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public CreateJobUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
