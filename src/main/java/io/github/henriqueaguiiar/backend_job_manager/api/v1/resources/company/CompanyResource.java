package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.company;


import io.github.henriqueaguiiar.backend_job_manager.domain.services.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyResource {


    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyResource(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }
}
