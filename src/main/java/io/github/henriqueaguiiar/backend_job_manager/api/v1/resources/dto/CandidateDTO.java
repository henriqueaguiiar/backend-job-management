package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    @Pattern(regexp = "^(?!\\s*$).+" , message = "Username cannot be blank")
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @Length(min = 10, max = 100, message = "Password must be between 10 and 100 characters")
    private String password;
    private String description;
    private String resume;

    public CandidateDTO(String name, String username, String email, String password, String description) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
    }
}
