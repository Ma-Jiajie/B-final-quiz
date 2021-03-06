package com.example.demo.controller;

import com.example.demo.controller.requestdto.TraineeRequestDTO;
import com.example.demo.controller.responsedto.TraineeResponseDTO;
import com.example.demo.model.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trainees")
// TODO GTB-知识点: - @Validated注解使用不合理
@Validated
@CrossOrigin
// TODO GTB-知识点: - CrossOrigin应指定特定域名
public class TraineeController {
    private final TraineeService traineeService;
    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    @GetMapping
    public List<TraineeResponseDTO> getTraineesByGrouped(@RequestParam(name = "grouped", required = false) Boolean grouped) {
        List<Trainee> trainees = traineeService.getTraineesByGrouped(grouped);
        return traineeService.toTraineeResponseDTOS(trainees);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeResponseDTO createTrainee(@RequestBody @Valid TraineeRequestDTO traineeRequestDTO) {
        Trainee trainee = traineeService.createTrainee(traineeRequestDTO);
        return new TraineeResponseDTO(
                trainee.getId(),
                trainee.getName()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTraineeById(@PathVariable Long id) {
        traineeService.deleteTrainee(id);
    }
}
