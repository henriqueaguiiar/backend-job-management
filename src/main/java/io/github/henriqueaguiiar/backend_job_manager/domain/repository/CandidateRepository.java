package io.github.henriqueaguiiar.backend_job_manager.domain.repository;


import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
