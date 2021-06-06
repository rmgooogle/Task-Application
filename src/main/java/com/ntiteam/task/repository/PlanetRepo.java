package com.ntiteam.task.repository;

import com.ntiteam.task.model.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
    Planet findByName(String name);
}
