package io.github.henriqueaguiiar.backend_job_manager.domain.entity;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Pattern(regexp = "^(?!\\s*$).+" , message = "Username cannot be blank")
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @Length(min = 10, max = 100, message = "Password must be between 10 and 100 characters")
    private String password;
    private String description;
    private String resume;
    @CreationTimestamp
    private Instant createdAt;


    public Candidate(CandidateDTO candidateDTO) {
        this.name = candidateDTO.getName();
        this.username = candidateDTO.getUsername();
        this.email = candidateDTO.getEmail();
        this.password = candidateDTO.getPassword();
        this.description = candidateDTO.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
