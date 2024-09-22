package ru.panov.bronting_service.mpper;

import org.mapstruct.Mapper;
import ru.panov.bronting_service.dto.ExecutorDto;
import ru.panov.bronting_service.entity.Executor;

@Mapper
public interface ExecutorMapper {

    ExecutorDto toExecutorDto(Executor executor);
    Executor fromExecutorDto(ExecutorDto executorDto);
}
