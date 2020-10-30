package com.example.demo.service;

import com.example.demo.controller.responsedto.GroupResponseDTO;
import com.example.demo.exception.NotEnoughtTrainers;
import com.example.demo.model.Group;
import com.example.demo.model.Trainee;
import com.example.demo.model.Trainer;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<Group> getAllGroups() {
        return Arrays.asList(separateGroups().clone());
    }

    public Group[] separateGroups() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        List<Trainee> trainees = traineeService.getAllTrainees();
        // TODO GTB-完成度: - 有两个trainer时应当分组
        if(trainers.size() <= 2) throw new NotEnoughtTrainers("Trainers number is less than 2");
        int groupSize = trainers.size()/2;
        Group[] groups = new Group[groupSize];
        for(int groupIndex=0; groupIndex<groupSize; groupIndex++) {
            groups[groupIndex] = new Group(
                    traineeIdSeq.incrementAndGet(),
                    "组"
            );
        }
        for(int trainerIndex=0, groupIndex=0; trainerIndex<groupSize*2; trainerIndex+=2 ,groupIndex++) {
            groups[groupIndex].getTrainers().add(trainers.get(trainerIndex));
            groups[groupIndex].getTrainers().add(trainers.get(trainerIndex+1));
            trainerService.updateGrouped(trainers.get(trainerIndex).getId());
            trainerService.updateGrouped(trainers.get(trainerIndex+1).getId());
        }
        for(int groupIndex=0, traineeIndex=0; traineeIndex < trainees.size(); traineeIndex++, groupIndex++) {
            Collections.shuffle(trainees);
            if(groupIndex == groupSize) groupIndex=0;
            groups[groupIndex].getTrainees().add(trainees.get(traineeIndex));
            traineeService.updateGrouped(trainees.get(traineeIndex).getId());
        }

        for(Group group: groups) { groupRepository.save(group); }
        return groups;
    }

    public List<GroupResponseDTO> toGroupResponseDTOS(List<Group> groups) {
        List<GroupResponseDTO> groupResponseDTOArrayList = new ArrayList<>();

        for (Group group: groups) {
            groupResponseDTOArrayList.add(
                    new GroupResponseDTO(
                            group.getId(),
                            group.getName(),
                            trainerService.toTrainerResponseDTOS(group.getTrainers()),
                            traineeService.toTraineeResponseDTOS(group.getTrainees())
                    )
            );
        }
        return groupResponseDTOArrayList;

    }
}
