package io.github.henriqueaguiiar.backend_job_manager.domain.services;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    void createCandidate(Candidate candidate);
}
