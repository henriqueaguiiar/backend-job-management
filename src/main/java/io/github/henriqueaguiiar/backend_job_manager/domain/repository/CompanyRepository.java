package io.github.henriqueaguiiar.backend_job_manager.domain.repository;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {


    @Query
    Optional<Company> findByUsernameOrEmail(String username, String email);


}
