package com.example.demo.service;

import com.example.demo.model.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TraineeService {
    private final AtomicLong userIdSeq = new AtomicLong();
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<Trainee> getTraineesByGrouped(Boolean grouped) {
        return traineeRepository.getAllByGrouped(grouped);
    }
}
