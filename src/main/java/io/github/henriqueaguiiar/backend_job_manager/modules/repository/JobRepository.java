package io.github.henriqueaguiiar.backend_job_manager.modules.repository;

import io.github.henriqueaguiiar.backend_job_manager.modules.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);

}
