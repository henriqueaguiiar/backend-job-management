package io.github.henriqueaguiiar.backend_job_manager.domain.services.exception.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionHandlerDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private String field;

}
