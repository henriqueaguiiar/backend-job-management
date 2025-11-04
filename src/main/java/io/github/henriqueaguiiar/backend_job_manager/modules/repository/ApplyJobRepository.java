package io.github.henriqueaguiiar.backend_job_manager.modules.repository;

import io.github.henriqueaguiiar.backend_job_manager.modules.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
