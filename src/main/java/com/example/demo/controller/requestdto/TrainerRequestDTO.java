package com.example.demo.controller.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerRequestDTO {

    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be empty")
    private String name;
}