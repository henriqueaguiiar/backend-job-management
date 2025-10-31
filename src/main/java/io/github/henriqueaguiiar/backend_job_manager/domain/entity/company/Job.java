package io.github.henriqueaguiiar.backend_job_manager.domain.entity.company;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.JobDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


@Entity(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;
    private  String level;




    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;


    @CreationTimestamp
    private Instant createdAt;


    public Job(JobDTO jobDTO) {
        this.description = jobDTO.getDescription();
        this.benefits = jobDTO.getBenefits();
        this.level = jobDTO.getLevel();
        this.companyId = jobDTO.getCompanyId();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
