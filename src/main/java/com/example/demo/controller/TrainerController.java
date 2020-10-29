package com.example.demo.controller;

import com.example.demo.controller.requestdto.TrainerRequestDTO;
import com.example.demo.controller.responsedto.TrainerResponseDTO;
import com.example.demo.model.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trainers")
@Validated
public class TrainerController {
    private final TrainerService trainerService;
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<TrainerResponseDTO> getTrainersByGrouped(@RequestParam(name = "grouped", required = false) Boolean grouped) {
        List<Trainer> trainers = trainerService.getTrainersByGrouped(grouped);
        return toTrainerResponseDTOS(trainers);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponseDTO createTrainer(@RequestBody @Valid TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = trainerService.createTrainer(trainerRequestDTO);
        return new TrainerResponseDTO(
                trainer.getId(),
                trainer.getName()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainerById(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }

    private List<TrainerResponseDTO> toTrainerResponseDTOS(List<Trainer> trainers) {
        List<TrainerResponseDTO> trainerResponseDTOS = new ArrayList<>();
        trainers.forEach(trainer -> trainerResponseDTOS.add(new TrainerResponseDTO(trainer.getId(), trainer.getName())));
        return trainerResponseDTOS;
    }
}
