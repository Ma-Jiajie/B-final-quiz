package com.example.demo.controller;

import com.example.demo.controller.responsedto.TraineesResponse;
import com.example.demo.model.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainees")
@Validated
public class TraineeController {
    private final TraineeService traineeService;
    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    @GetMapping
    public TraineesResponse getTraineesByGrouped(@RequestParam(name = "grouped", required = false) Boolean grouped) {
        List<Trainee> trainees = traineeService.getTraineesByGrouped(grouped);
        return new TraineesResponse(trainees);
    }
}
