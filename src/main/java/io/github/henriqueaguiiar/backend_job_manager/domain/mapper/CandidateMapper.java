package io.github.henriqueaguiiar.backend_job_manager.domain.mapper;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateDTO toDTO(Candidate candidate);
    Candidate toEntity(CandidateDTO candidateDTO);


}
