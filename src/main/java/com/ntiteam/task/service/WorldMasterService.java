package com.ntiteam.task.service;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.dto.SaveMasterDto;
import com.ntiteam.task.dto.UpdateDto;

import java.util.List;

public interface WorldMasterService {


    /**
     * Возвращает список всех повелителей
     *
     * @return - List  <{@link PlanetDto}>
     */
    List<MasterDto> getAll();

    /**
     * озвращает повелителя по id
     *
     * @param id -
     * @return - возвращает {@link PlanetDto}
     */
    MasterDto getMasterById(Long id);

    /**
     * возвращает планету по id
     *
     * @param id
     * @return - возвращает {@link PlanetDto}
     */
    PlanetDto getPlanetById(Long id);

    /**
     * создание нового повелителя
     *
     *@param dto - Состоит из двух параметров {@link SaveMasterDto#getName()} , {@link SaveMasterDto#getAge()}
     */
    void createMaster(SaveMasterDto dto);

    /**
     * создание новой планеты
     *
     * @param name - Имя планеты
     */
    void createPlanet(String name);

    /**
     * удаление планеты по id
     *
     * @param id
     */
    void deletePlanetById(Long id);

    /**
     * Назначение планеты повелителю
     *
     * @param updateDto - Состоит из двух id {masterId, planetId}
     * @return - возвращаются обновленный Master
     */
    MasterDto updateMasterByPlanet(UpdateDto updateDto);

    /**
     * @return - Возвращает список повелителей не имеющих планет
     */
    List<MasterDto> getSlackers();

    /**
     * @return - List<Master> возвращает 10 молодых отсортированных повелителей
     */
    List<MasterDto> getTenYoungMasters();
}
