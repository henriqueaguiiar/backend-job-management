package io.github.henriqueaguiiar.backend_job_manager.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class SecurityConfiguration {

    /**
     * Metodo de segurança para liberar rotas candidatos e company e bloquear as outras
     *
     * @param http um request
     * @return configuração de autenticação
     * @throws Exception
     */

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity  http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("api/v1/candidates").permitAll()
                            .requestMatchers("api/v1/company").permitAll()
                            .requestMatchers("api/v1/auth/company").permitAll()
                            .anyRequest().authenticated();
                });
        return  http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
