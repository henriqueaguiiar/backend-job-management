package io.github.henriqueaguiiar.backend_job_manager.infra.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {

    @Value("${spring.security.token.secret}")
    private String secret;

    public String validateToken(String token){
        token = token.replace("Bearer ", ""); // remove o prefixo "Bearer "
        try {
            // usa a chave secreta para validar
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
