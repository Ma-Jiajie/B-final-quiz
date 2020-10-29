package com.example.demo.repository;
import com.example.demo.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long>{
    List<Trainee> getAllByGrouped(Boolean grouped);
    Trainee getOneById(Long id);
    @Modifying
    @Transactional
    @Query(value = "update trainee t set t.grouped=true where t.id=?1", nativeQuery = true)
    void updateGrouped(Long id);
}
