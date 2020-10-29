package com.example.demo.service;

import com.example.demo.controller.requestdto.TraineeRequestDTO;
import com.example.demo.model.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

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
}
