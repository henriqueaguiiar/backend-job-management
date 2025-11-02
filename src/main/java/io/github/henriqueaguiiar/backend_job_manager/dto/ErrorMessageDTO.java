package io.github.henriqueaguiiar.backend_job_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

    private String message;
    private String field;
}
