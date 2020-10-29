package com.example.demo.repository;

import com.example.demo.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    List<Trainer> getAllByGrouped(Boolean grouped);
    Trainer getOneById(Long id);
}