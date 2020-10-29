package com.example.demo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name should not be empty")
    private String name;

    @OneToMany
    private List<Trainer> trainers;
    @OneToMany
    private List<Trainee> trainees;
}
