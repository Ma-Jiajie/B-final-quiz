package com.example.demo.controller;

import com.example.demo.controller.responsedto.GroupResponseDTO;
import com.example.demo.model.Group;
import com.example.demo.service.GroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
@Validated
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupResponseDTO> getAllGroups() {
        return groupService.toGroupResponseDTOS(groupService.getAllGroups());
    }


}
