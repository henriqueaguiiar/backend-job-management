package io.github.henriqueaguiiar.backend_job_manager.domain.mapper;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CompanyDTO;
import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.JobDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Company;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.company.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobDTO toDTO(Job job);
    Job toEntity(JobDTO jobDTO);

}
