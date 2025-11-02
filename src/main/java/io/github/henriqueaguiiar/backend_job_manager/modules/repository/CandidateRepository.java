package io.github.henriqueaguiiar.backend_job_manager.modules.repository;

import io.github.henriqueaguiiar.backend_job_manager.modules.entities.CandidateEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
