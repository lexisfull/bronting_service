package ru.panov.bronting_service.dto;

import ru.panov.bronting_service.entity.CoachType;
import ru.panov.bronting_service.entity.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExecutorDto {

    Long id;

    Long personId;

    String name;

    Long age;

    Long experience;

    CoachType type;

    List<Person> persons;

}
