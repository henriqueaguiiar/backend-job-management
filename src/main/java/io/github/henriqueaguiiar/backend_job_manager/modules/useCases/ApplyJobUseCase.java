package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;


import io.github.henriqueaguiiar.backend_job_manager.exceptions.JobNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.exceptions.UserNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CandidateRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobUseCase {

    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;


    @Autowired
    public ApplyJobUseCase(CandidateRepository candidateRepository, JobRepository jobRepository) {
        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;
    }

    public void execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate).orElseThrow(() ->{
            throw new UserNotFoundException();
        });


        this.jobRepository.findById(idJob).orElseThrow(() ->{
            throw new JobNotFoundException();
        });
    }


}
