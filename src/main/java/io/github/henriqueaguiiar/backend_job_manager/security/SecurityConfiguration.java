package io.github.henriqueaguiiar.backend_job_manager.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
                            .anyRequest().authenticated();
                });
        return  http.build();
    }

}
