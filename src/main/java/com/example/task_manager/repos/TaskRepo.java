package com.example.task_manager.repos;

import com.example.task_manager.domin.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface TaskRepo extends JpaRepository<Task, Long> {


    @Query("update tasks " +
            "set status = ?1 " +
            "where id = ?2")
    Optional<Task> updateTask (String status, Long id);

}
