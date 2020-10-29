package com.example.demo.controller.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResponseDTO {
    private Long id;
    @NotNull(message = "name should not be empty")
    private String name;
}
