package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.company;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CompanyDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.auth.AuthCompanyService;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.auth.dto.AuthCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthCompanyResource {

    private final AuthCompanyService authCompanyService;

    @Autowired
    public AuthCompanyResource(AuthCompanyService authCompanyService) {
        this.authCompanyService = authCompanyService;
    }

    @PostMapping("/company")
    public ResponseEntity<Object> createCompany(@RequestBody AuthCompanyDTO authCompanyDTO) {

        try{
            var result = this.authCompanyService.CompanyValidate(authCompanyDTO);
            return  ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }



    }
}
