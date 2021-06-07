package com.ntiteam.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MASTERS")
public class Master {

    public Master(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя мастера
     */
    @Column(name = "name")
    private String name;

    /**
     * Возраст мастера
     */
    @Column(name = "age")
    private Long age;

    /**
     * Связь мастера с планетой
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "master")
    private List<Planet> planets = new ArrayList<>();
}
