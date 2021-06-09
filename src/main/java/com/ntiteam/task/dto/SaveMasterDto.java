package com.ntiteam.task.dto;

import com.ntiteam.task.model.Master;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveMasterDto {

    /**
     * {@link Master#getName()}
     */
    private String name;

    /**
     * {@link Master#getAge()}
     */
    private Long age;
}
