package io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String resume;
}
