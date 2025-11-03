package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.henriqueaguiiar.backend_job_manager.dto.AuthCandidateRequestDTO;
import io.github.henriqueaguiiar.backend_job_manager.dto.AuthCandidateResponseDTO;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthCandidateUseCase {

    @Value("${spring.security.token.secret-candidate}")
    private String secretKey;

    private final CandidateRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthCandidateUseCase(CandidateRepository candidateRepository, PasswordEncoder passwordEncoder) {
        this.candidateRepository = candidateRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateRequestDTO) throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authCandidateRequestDTO.username())
                .orElseThrow(() ->{
                    throw new UsernameNotFoundException("Username/password incorrect");
                });

        var passwordMatches = this.passwordEncoder.matches(authCandidateRequestDTO.password(), candidate.getPassword());
        if(!passwordMatches) {
            throw new AuthenticationException();
        }

        var roles = Arrays.asList("CANDIDATE");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("javagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", roles)
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        var authCandidateResponse = AuthCandidateResponseDTO.builder()
                .access_token(token)
                .expiresIn(expiresIn.toEpochMilli())
                .build();
        return authCandidateResponse;
    }
}
