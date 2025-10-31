package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.candidate;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import io.github.henriqueaguiiar.backend_job_manager.domain.mapper.CandidateMapper;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.impl.CandidateServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateResource {


    private final CandidateServiceImpl candidateService;
    private final CandidateMapper candidateMapper;

    @Autowired
    public CandidateResource(CandidateServiceImpl candidateService, CandidateMapper candidateMapper) {
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateDTO candidateDTO) {
        try{
            Candidate candidate = candidateMapper.toEntity(candidateDTO);
           candidateService.createCandidate( candidate );
           var result = ResponseEntity.created(URI.create("/api/v1/candidates/" + candidate.getId())).body(candidateMapper.toDTO(candidate));
           return ResponseEntity.ok().body(result);
       }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
