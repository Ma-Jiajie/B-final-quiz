package com.example.demo.controller.responsedto;

import com.example.demo.model.Trainee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraineesResponse {
    private List<Trainee> trainees;
}
