package io.github.henriqueaguiiar.backend_job_manager.domain.services.impl;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import io.github.henriqueaguiiar.backend_job_manager.domain.repository.CompanyRepository;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.CompanyService;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.exception.CompanyFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void createCompany(Company company) {
        this.companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((companyFind) -> {
                    throw new CompanyFoundException();
                });
        var password = passwordEncoder.encode(company.getPassword());
        company.setPassword(password);
        this.companyRepository.save(company);
    }
}
