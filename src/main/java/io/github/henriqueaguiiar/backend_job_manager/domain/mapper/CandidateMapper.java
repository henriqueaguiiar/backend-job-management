package io.github.henriqueaguiiar.backend_job_manager.domain.mapper;


import io.github.henriqueaguiiar.backend_job_manager.api.v1.resources.dto.CandidateDTO;
import io.github.henriqueaguiiar.backend_job_manager.domain.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    CandidateDTO toDTO(Candidate candidate);

    Candidate toEntity(CandidateDTO candidateDTO);


}
