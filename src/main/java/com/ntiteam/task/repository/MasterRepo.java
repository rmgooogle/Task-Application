package com.ntiteam.task.repository;

import com.ntiteam.task.model.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepo extends JpaRepository<Master, Long> {
    Master findByName(String name);
}
