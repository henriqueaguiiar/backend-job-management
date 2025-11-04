package io.github.henriqueaguiiar.backend_job_manager.modules.useCases;


import io.github.henriqueaguiiar.backend_job_manager.exceptions.JobNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.exceptions.UserNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.modules.entities.ApplyJobEntity;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.ApplyJobRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CandidateRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobUseCase {

    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;
    private final ApplyJobRepository applyJobRepository;

    @Autowired
    public ApplyJobUseCase(CandidateRepository candidateRepository, JobRepository jobRepository, ApplyJobRepository applyJobRepository) {
        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;
        this.applyJobRepository = applyJobRepository;
    }

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate).orElseThrow(() ->{
            throw new UserNotFoundException();
        });


        this.jobRepository.findById(idJob).orElseThrow(() ->{
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder()
                        .candidateId(idCandidate)
                                .jobId(idJob)
                                        .build();
        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }

}
