package com.ntiteam.task.service;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.PlanetDto;

import java.util.List;

public interface WorldMasterService {

    /**
     * @return - Возвращает список всех повелителей
     */
    List<MasterDto> getAll();

    /**
     * @param id -
     * @return - возвращает повелителя по id
     */
    MasterDto getMasterById(Long id);

    /**
     * @param id
     * @return - возвращает планету по id
     */
    PlanetDto getPlanetById(Long id);

    /**
     * создание нового повелителя
     *
     * @param name - Има повелителя
     * @param age  - Возраст повелителя
     */
    void createMaster(String name, Long age);

    /**
     * создание новой планеты
     *
     * @param name - Planet name
     */
    void createPlanet(String name);

    /**
     * удаление планеты по id
     *
     * @param id
     */
    void deletePlanetById(Long id);

    /**
     * @param idPlanet - id планеты, которой назначается мастер
     * @param idMaster - id повелителя, к которому добавляется планета
     * @return - возвращаются обновленный Master
     */
    MasterDto updateMasterByPlanet(Long idPlanet, Long idMaster);

    /**
     * @return - Возвращает список повелителей не имеющих планет
     */
    List<MasterDto> getSlackers();

    /**
     * @return - List<Master> возвращает 10 молодых отсортированных повелителей
     */
    List<MasterDto> getTenYoungMasters();
}
