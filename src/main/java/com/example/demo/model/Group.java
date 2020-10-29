package com.example.demo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainer> trainers = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
