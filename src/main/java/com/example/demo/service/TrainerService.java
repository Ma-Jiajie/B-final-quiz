package com.example.demo.service;

import com.example.demo.controller.requestdto.TrainerRequestDTO;
import com.example.demo.controller.responsedto.TrainerResponseDTO;
import com.example.demo.exception.TrainerNotFoundException;
import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TrainerService {
    private final AtomicLong trainerIdSeq = new AtomicLong();
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainersByGrouped(Boolean grouped) {
        return trainerRepository.getAllByGrouped(grouped);
    }

    public Trainer createTrainer(TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = new Trainer(
                trainerIdSeq.incrementAndGet(),
                trainerRequestDTO.getName(),
                false);

        trainerRepository.save(trainer);
        return trainer;
    }

    public Trainer gettrainerByid(Long id) {
        return trainerRepository.getOneById(id);
    }

    public void deleteTrainer(Long id) {
        if(gettrainerByid(id) == null) throw new TrainerNotFoundException("Trainer is not Existing");
        trainerRepository.deleteById(id);
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public List<TrainerResponseDTO> toTrainerResponseDTOS(List<Trainer> trainers) {
        List<TrainerResponseDTO> trainerResponseDTOS = new ArrayList<>();
        trainers.forEach(trainer -> trainerResponseDTOS.add(new TrainerResponseDTO(trainer.getId(), trainer.getName())));
        return trainerResponseDTOS;
    }
}
