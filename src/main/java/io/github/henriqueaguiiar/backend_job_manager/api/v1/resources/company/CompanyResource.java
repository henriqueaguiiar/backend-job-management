package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.company;



import io.github.henriqueaguiiar.backend_job_manager.domain.entity.dto.CompanyDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.impl.CompanyServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/company")
public class CompanyResource {


    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyResource(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        try {
            Company company = new Company(companyDTO);
            companyService.createCompany(company);
            companyDTO.setPassword(company.getPassword());
            var result = ResponseEntity.created(URI.create("/api/v1/company" + company.getId())).body(companyDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






}
