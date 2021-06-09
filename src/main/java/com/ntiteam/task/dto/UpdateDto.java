package com.ntiteam.task.dto;

import com.ntiteam.task.model.Master;
import com.ntiteam.task.model.Planet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {

    /**
     * {@link Master#getId()}
     */
    private Long masterId;

    /**
     * {@link Planet#getId()}
     */
    private Long planetId;
}
