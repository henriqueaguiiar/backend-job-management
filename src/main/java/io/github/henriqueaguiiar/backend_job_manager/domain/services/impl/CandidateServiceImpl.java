package io.github.henriqueaguiiar.backend_job_manager.domain.services.impl;

import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import io.github.henriqueaguiiar.backend_job_manager.domain.repository.CandidateRepository;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void createCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }
}
