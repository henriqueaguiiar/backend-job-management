package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.candidate;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateResource {



    @PostMapping
    public ResponseEntity<Candidate> create(@Valid @RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate(candidateDTO);
        return ResponseEntity.ok().body(candidate);
    }

}
