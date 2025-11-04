package io.github.henriqueaguiiar.backend_job_manager.modules.entity.UseCases;


import io.github.henriqueaguiiar.backend_job_manager.exceptions.JobNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.exceptions.UserNotFoundException;
import io.github.henriqueaguiiar.backend_job_manager.modules.entities.CandidateEntity;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.CandidateRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.repository.JobRepository;
import io.github.henriqueaguiiar.backend_job_manager.modules.useCases.ApplyJobUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ApplyJobUseCaseTest {

    @InjectMocks
    private ApplyJobUseCase applyJobUseCase;

    @Mock
    private CandidateRepository candidateRepository;
    @Mock
    private JobRepository jobRepository;


    @Test
    @DisplayName("should not be able to apply job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found(){
        try{
            applyJobUseCase.execute(null, null);
        }catch (Exception e){
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("should not be able to apply job with job not found")
    public void should_not_be_able_to_apply_job_with_job_not_found(){
        var idCandidate = UUID.randomUUID();
        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);
        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try{
            applyJobUseCase.execute(idCandidate, null);
        }catch (Exception e){
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }

    }

}
