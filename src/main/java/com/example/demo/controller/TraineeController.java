package com.example.demo.controller;

import com.example.demo.controller.responsedto.TraineeResponseDTO;
import com.example.demo.model.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<TraineeResponseDTO> getTraineesByGrouped(@RequestParam(name = "grouped", required = false) Boolean grouped) {
        List<Trainee> trainees = traineeService.getTraineesByGrouped(grouped);
        return toTraineeResponseDTOS(trainees);
    }



    private List<TraineeResponseDTO> toTraineeResponseDTOS(List<Trainee> trainees) {
        List<TraineeResponseDTO> traineeResponseDTOS = new ArrayList<>();
        trainees.forEach(trainee -> traineeResponseDTOS.add(new TraineeResponseDTO(trainee.getId(), trainee.getName())));
        return traineeResponseDTOS;
    }
}
