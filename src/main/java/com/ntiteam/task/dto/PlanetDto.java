package com.ntiteam.task.dto;

import com.ntiteam.task.model.Planet;
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
     * {@link Planet#getId()}
     */
    private Long id;

    /**
     * {@link Planet#getName()}
     */
    private String name;
}
