package com.example.demo.repository;

import com.example.demo.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    List<Trainer> getAllByGrouped(Boolean grouped);
    Trainer getOneById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update trainer t set t.grouped=true where t.id=?1", nativeQuery = true)
    void updateGrouped(Long id);
}