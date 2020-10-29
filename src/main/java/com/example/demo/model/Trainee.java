package com.example.demo.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name should not be null")
    private String name;
    private Boolean grouped;
}
