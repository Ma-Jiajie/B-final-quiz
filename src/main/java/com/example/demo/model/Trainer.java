package com.example.demo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name should not be null")
    private String name;
    private Boolean grouped;

    @ManyToOne
    private Group group;
}
