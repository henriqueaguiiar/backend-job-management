package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.candidate;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.impl.CandidateServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateResource {


    private final CandidateServiceImpl candidateService;

    @Autowired
    public CandidateResource(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<Candidate> create(@Valid @RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate(candidateDTO);
        candidateService.createCandidate( candidate );
        return ResponseEntity.ok().body(candidate);
    }

}
