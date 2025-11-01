package io.github.henriqueaguiiar.backend_job_manager.domain.entity.dto;


import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String description;
    private String benefits;
    @NotBlank(message = "This field is not blank")
    private  String level;

    private UUID companyId;


    private Instant createdAt;

}