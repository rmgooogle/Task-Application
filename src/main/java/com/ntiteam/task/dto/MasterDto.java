package com.ntiteam.task.dto;

import com.ntiteam.task.model.Master;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MasterDto {

    public MasterDto(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    /**
     * {@link Master#getId()}
     */
    private Long id;

    /**
     * {@link Master#getName()}
     */
    private String name;

    /**
     * {@link Master#getAge()}
     */
    private Long age;

    /**
     * {@link Master#getPlanets()}
     */
    private List<PlanetDto> planets;
}
