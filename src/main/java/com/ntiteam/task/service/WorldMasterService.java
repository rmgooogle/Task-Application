package com.ntiteam.task.service;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.PlanetDto;

import java.util.List;

public interface WorldMasterService {

    /**
     * @return - all Masters
     */
    List<MasterDto> getAll();

    /**
     * @param id -
     * @return - MasterDto
     */
    MasterDto getMasterById(Long id);

    /**
     * @param id
     * @return Planet by id
     */
    PlanetDto getPlanetById(Long id);

    /**
     * create new Master
     *
     * @param name - master name
     * @param age  - master age
     */
    void createMaster(String name, Long age);

    /**
     * create new Planet
     *
     * @param name - Planet name
     */
    void createPlanet(String name);

    /**
     * delete Planet by id
     *
     * @param id
     */
    void deletePlanetById(Long id);

    /**
     * @param idPlanet - id Planet, которой назначается мастер
     * @param idMaster - id Master, к которому добавляется планета
     * @return - возвращаются обновленный Master
     */
    MasterDto updateMasterByPlanet(Long idPlanet, Long idMaster);

    /**
     * @return - Возвращает список Masters не имеющих планет
     */
    List<MasterDto> getSlackers();

    /**
     * @return - List<Master> top 10 young Masters
     */
    List<MasterDto> getTenYoungMasters();
}
