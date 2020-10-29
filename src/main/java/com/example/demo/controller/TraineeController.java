package com.example.demo.controller;

import com.example.demo.controller.requestdto.TraineeRequestDTO;
import com.example.demo.controller.responsedto.TraineeResponseDTO;
import com.example.demo.model.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeResponseDTO createTrainee(@RequestBody TraineeRequestDTO traineeRequestDTO) {
        Trainee trainee = traineeService.createTrainee(traineeRequestDTO);
        return new TraineeResponseDTO(
                trainee.getId(),
                trainee.getName()
        );
    }

    private List<TraineeResponseDTO> toTraineeResponseDTOS(List<Trainee> trainees) {
        List<TraineeResponseDTO> traineeResponseDTOS = new ArrayList<>();
        trainees.forEach(trainee -> traineeResponseDTOS.add(new TraineeResponseDTO(trainee.getId(), trainee.getName())));
        return traineeResponseDTOS;
    }
}
