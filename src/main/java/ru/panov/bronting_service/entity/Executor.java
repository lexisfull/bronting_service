package ru.panov.bronting_service.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Executor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "coachType")
    private CoachType coachType;



    @ManyToMany
    @JoinTable(
            name = "person_executor",
            joinColumns = @JoinColumn(name = "executor"),
            inverseJoinColumns = @JoinColumn(name = "person")

    )
    private List<Person> persons;
}
