package io.github.henriqueaguiiar.backend_job_manager.domain.repository;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {

}
