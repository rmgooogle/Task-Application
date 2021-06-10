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
     * Возвращает повелителя по id
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
     * Создание нового повелителя
     *
     *@param dto - Состоит из двух параметров {@link SaveMasterDto#getName()} , {@link SaveMasterDto#getAge()}
     */
    void createMaster(SaveMasterDto dto);

    /**
     * Создание новой планеты
     *
     * @param name - Имя планеты
     */
    void createPlanet(String name);

    /**
     * Удаление планеты по id
     *
     * @param id - id планеты
     */
    void deletePlanetById(Long id);

    /**
     * Назначение планеты повелителю
     *
     * @param updateDto - Состоит из двух id {masterId, planetId}
     * @return - возвращаются обновленный  List  <{@link MasterDto}>
     */
    MasterDto updateMasterByPlanet(UpdateDto updateDto);

    /**
     * Возвращает список повелителей не имеющих планет
     *
     * @return -  List  <{@link MasterDto}>
     */
    List<MasterDto> getSlackers();

    /**
     * Возвращает 10 молодых отсортированных повелителей
     *
     * @return - List  <{@link MasterDto}>
     */
    List<MasterDto> getTenYoungMasters();
}
