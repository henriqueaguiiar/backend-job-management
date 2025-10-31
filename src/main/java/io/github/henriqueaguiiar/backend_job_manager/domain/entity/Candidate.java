package io.github.henriqueaguiiar.backend_job_manager.domain.entity;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_candidate", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String resume;


    
    public Candidate(CandidateDTO candidateDTO) {
        this.name = candidateDTO.getName();
        this.username = candidateDTO.getUsername();
        this.email = candidateDTO.getEmail();
        this.password = candidateDTO.getPassword();
        this.description = candidateDTO.getDescription();
        this.resume = candidateDTO.getResume();
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
