package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;

import io.github.henriqueaguiiar.backend_job_manager.exceptions.UserFoundException;
import io.github.henriqueaguiiar.backend_job_manager.modules.entities.CandidateEntity;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent(user -> {
            throw new UserFoundException();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
