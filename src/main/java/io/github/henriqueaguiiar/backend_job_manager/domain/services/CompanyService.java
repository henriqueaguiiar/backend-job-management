package io.github.henriqueaguiiar.backend_job_manager.domain.services;


import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    void createCompany(Company company);
}
