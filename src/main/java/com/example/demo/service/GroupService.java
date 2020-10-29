package com.example.demo.service;

import com.example.demo.exception.NotEnoughtTrainers;
import com.example.demo.model.Group;
import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GroupService {
    private final AtomicLong traineeIdSeq = new AtomicLong();
    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final GroupRepository groupRepository;

    public GroupService(TraineeService traineeService, TrainerService trainerService, GroupRepository groupRepository) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.groupRepository = groupRepository;
    }

    public Group[] separateGroups() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        List<Trainee> trainees = traineeService.getAllTrainees();
        if(trainers.size() <= 2) throw new NotEnoughtTrainers("Trainers number is less than 2");
        int groupSize = trainers.size()/2;
        Group[] groups = new Group[groupSize];
        for(Group group: groups) {
            group = new Group(
                    traineeIdSeq.incrementAndGet(),
                    "组"
            );
        }
        for(int trainerIndex=0, groupIndex=0;trainerIndex<trainers.size();trainerIndex++) {
            groups[groupIndex].getTrainers().add(trainers.get(trainerIndex));
            if((trainerIndex+1)%2==0) groupIndex++;
        }
        for(int groupIndex=0, traineeIndex=0; traineeIndex < trainees.size(); traineeIndex++, groupIndex++) {
            if(groupIndex == groupSize) groupIndex=0;
            groups[groupIndex].getTrainees().add(trainees.get(traineeIndex));
        }

        return groups;
    }
}
