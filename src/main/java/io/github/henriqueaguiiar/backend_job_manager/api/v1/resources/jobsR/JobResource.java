package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.jobsR;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.JobDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Job;
import io.github.henriqueaguiiar.backend_job_manager.domain.services.impl.JobServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/job")
public class JobResource {

    private final JobServiceImpl jobService;

    @Autowired
    public JobResource(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Object> createJob(@Valid @RequestBody JobDTO jobDTO) {
        Job job = new Job(jobDTO);
        jobService.createJob(job);
        return ResponseEntity.created(URI.create("/api/v1/job")).body(jobDTO);
    }
}
