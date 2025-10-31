package io.github.henriqueaguiiar.backend_job_manager.domain.repository;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

    @Query
    Optional<Candidate> findByUsernameOrEmail(String username, String email);

}
