package com.ntiteam.task.service;

import com.ntiteam.task.model.dto.MasterDto;
import com.ntiteam.task.model.dto.PlanetDto;

import java.util.List;

public interface WorldMasterService {

    /**
     * @return all Masters
     */
    List<MasterDto> getAll();

    /**
     * @param id
     * @return Masters by id
     */
    MasterDto getMasterById(Long id);

    /**
     * @param id
     * @return Planet by id
     */
    PlanetDto getPlanetById(Long id);

    /**
     * create new Masters
     * Masters.Name = @param name,
     * Masters.Age = @param age
     */
    void createMaster(String name, Long age);

    /**
     * @param name create new Planet
     *             Planet.name = @param name
     */
    PlanetDto createPlanet(String name);

    /**
     * delete Planet by
     *
     * @param id
     */
    void deletePlanetById(Long id);

    /**
     * @param idPlanet
     * @param idMaster
     * @return updated Masters
     */
    MasterDto updateMasterByPlanet(Long idPlanet, Long idMaster);

    /**
     * @return slackers (Masters without planets)
     */
    List<MasterDto> getSlackers();

    /**
     * @return top 10 young Masters
     */
    List<MasterDto> getTenYoungMasters();
}
