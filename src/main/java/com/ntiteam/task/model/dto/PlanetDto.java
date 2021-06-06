package com.ntiteam.task.model.dto;

import com.ntiteam.task.model.entity.Planet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanetDto {

    /**
     * {@link Planet#getName()}
     */
    private String name;
}
