package com.example.demo.service;

import com.example.demo.controller.requestdto.TraineeRequestDTO;
import com.example.demo.controller.responsedto.TraineeResponseDTO;
import com.example.demo.exception.TraineeNotFoundException;
import com.example.demo.model.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TraineeService {
    private final AtomicLong traineeIdSeq = new AtomicLong();
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<Trainee> getTraineesByGrouped(Boolean grouped) {
        return traineeRepository.getAllByGrouped(grouped);
    }

    public Trainee createTrainee(TraineeRequestDTO traineeRequestDTO) {
        Trainee trainee = new Trainee(
                traineeIdSeq.incrementAndGet(),
                traineeRequestDTO.getName(),
                false);

        traineeRepository.save(trainee);
        return trainee;
    }

    public Trainee getTraineeByid(Long id) {
        return traineeRepository.getOneById(id);
    }

    public void deleteTrainee(Long id) {
        if(getTraineeByid(id) == null) throw new TraineeNotFoundException("Trainee is not Existing");
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    public List<TraineeResponseDTO> toTraineeResponseDTOS(List<Trainee> trainees) {
        List<TraineeResponseDTO> traineeResponseDTOS = new ArrayList<>();
        trainees.forEach(trainee -> traineeResponseDTOS.add(new TraineeResponseDTO(trainee.getId(), trainee.getName())));
        return traineeResponseDTOS;
    }
}
