package com.ntiteam.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLANETS")
public class Planet {

    public Planet(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Наименование планеты
     */
    @Column(name = "name")
    private String name;

    /**
     * Привязка планеты к мастеру
     */
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master master;
}
