package com.example.demo.controller.responsedto;
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
public class GroupResponseDTO {
    @Id
    private Long id;
    @NotEmpty(message = "name should not be empty")
    private String name;
    // TODO GTB-知识点: - 有默认值的情况，应使用Lombok的@Builder.Default
    @Builder.Default
    private List<TrainerResponseDTO> trainers = new ArrayList<>();
    @Builder.Default
    private List<TraineeResponseDTO> trainees = new ArrayList<>();
}
