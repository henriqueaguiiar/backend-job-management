package io.github.henriqueaguiiar.backend_job_manager.dto;

import lombok.Data;

@Data
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}
