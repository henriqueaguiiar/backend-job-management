package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.company;



import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CompanyDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import io.github.henriqueaguiiar.backend_job_manager.domain.mapper.CompanyMapper;
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
@RequestMapping("/api/v1/company")
public class CompanyResource {


    private final CompanyServiceImpl companyService;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyResource(CompanyServiceImpl companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @PostMapping
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        try {
            Company company = companyMapper.toEntity(companyDTO);
            companyService.createCompany(company);
            var result = ResponseEntity.created(URI.create("/api/v1/company" + company.getId())).body(companyMapper.toDTO(company));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






}
