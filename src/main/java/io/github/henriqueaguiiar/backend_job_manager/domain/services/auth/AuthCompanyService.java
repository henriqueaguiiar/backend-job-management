package io.github.henriqueaguiiar.backend_job_manager.domain.services.auth;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.henriqueaguiiar.backend_job_manager.domain.repository.CompanyRepository;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.auth.dto.AuthCompanyDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyService {


    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.security.token.secret}")
    private String key;

    @Autowired
    public AuthCompanyService(CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Valida User e senha encriptada
     * @param authCompanyDTO
     * @return
     */

    public String CompanyValidate(AuthCompanyDTO authCompanyDTO) {
        var company = companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() ->{
                   throw new UsernameNotFoundException("Company not found");
                });
        var passwordsMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordsMatches){
            throw new ArithmeticException();
        }


        //Gera um TOKEN JWT pegado issuer id do objeto usando algoritimo HMAC256 usando a secret do application.yml
        Algorithm algorithm = Algorithm.HMAC256(key);
        var token = JWT.create().withIssuer("javagas")
                .withSubject(company.getId().toString()).withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .sign(algorithm);
        return token.toString();

    }
}
