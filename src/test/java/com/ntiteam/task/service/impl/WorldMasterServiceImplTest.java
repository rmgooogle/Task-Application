package com.ntiteam.task.service.impl;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.dto.SaveMasterDto;
import com.ntiteam.task.dto.UpdateDto;
import com.ntiteam.task.exception.MasterNotFoundException;
import com.ntiteam.task.exception.PlanetNotFoundException;
import com.ntiteam.task.model.Master;
import com.ntiteam.task.model.Planet;
import com.ntiteam.task.repository.MasterRepo;
import com.ntiteam.task.repository.PlanetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorldMasterServiceImplTest {

    @InjectMocks
    WorldMasterServiceImpl worldMasterServiceTest;

    @Mock
    MasterRepo masterRepoTest;

    @Mock
    PlanetRepo planetRepoTest;

    @Mock
    ModelMapper modelMapper;

    MasterDto masterDto = new MasterDto();
    SaveMasterDto saveMasterDto;
    UpdateDto updateDto;
    Master master = new Master();
    PlanetDto planetDto;
    Planet planet = new Planet();
    List<Planet> planets = new ArrayList<>();
    List<PlanetDto> planetDtos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.worldMasterServiceTest = new WorldMasterServiceImpl(masterRepoTest, planetRepoTest, modelMapper);

        planetDto = new PlanetDto(1L, "TestName");
        saveMasterDto = new SaveMasterDto("TestName", 26L);
        updateDto = new UpdateDto(1L, 1L);

        planet.setName("TestName");
        planet.setId(1L);

        planetDtos.add(planetDto);
        planets.add(planet);

        masterDto.setId(1L);
        masterDto.setName("TestName");
        masterDto.setAge(26L);

        master.setId(1L);
        master.setName("TestName");
        master.setAge(26L);
    }

    @Test
    void getAll() {
        List<Master> masters = new ArrayList<>();
        when(modelMapper.map(any(), any())).thenReturn(master);
        masters.add(modelMapper.map(masterDto, Master.class));
        when(masterRepoTest.findAll()).thenReturn(masters);
        when(modelMapper.map(any(), any())).thenReturn(masterDto);
        List<MasterDto> masterDtos = worldMasterServiceTest.getAll();
        verify(masterRepoTest, times(1)).findAll();
        assertNotNull(masterDtos);
        assertEquals(masterDtos.size(), 1);
        assertEquals(masters.size(), 1);
    }

    @Test
    void getMasterById() {
        Mockito.when(modelMapper.map(any(), any())).thenReturn(masterDto);
        Mockito.when(masterRepoTest.findById(anyLong())).thenReturn(Optional.of(master));
        MasterDto returnedMasterDto = worldMasterServiceTest.getMasterById(1L);
        assertNotNull(returnedMasterDto);
        assertEquals(returnedMasterDto.getId(), 1L);
        verify(masterRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void getMasterExceptionById() {
        Mockito.when(masterRepoTest.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(MasterNotFoundException.class, () -> worldMasterServiceTest.getMasterById(1L));
        verify(masterRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void getPlanetById() {
        Mockito.when(modelMapper.map(any(), any())).thenReturn(planetDto);
        Mockito.when(planetRepoTest.findById(anyLong())).thenReturn(Optional.of(planet));
        PlanetDto returnedPlanetDto = worldMasterServiceTest.getPlanetById(1L);
        assertNotNull(returnedPlanetDto);
        assertEquals(returnedPlanetDto.getId(), 1L);
        verify(planetRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void getPlanetExceptionById() {
        Mockito.when(planetRepoTest.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(PlanetNotFoundException.class, () -> worldMasterServiceTest.getPlanetById(1L));
        verify(planetRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void createMaster() {
        worldMasterServiceTest.createMaster(saveMasterDto);
        worldMasterServiceTest.createMaster(saveMasterDto);
        verify(masterRepoTest, times(2)).save(any());
    }

    @Test
    void createPlanet() {
        worldMasterServiceTest.createPlanet(planet.getName());
        verify(planetRepoTest, times(1)).save(any());
    }

    @Test
    void deletePlanetById() {
        when(planetRepoTest.findById(anyLong())).thenReturn(Optional.of(planet));
        worldMasterServiceTest.deletePlanetById(1L);
        verify(planetRepoTest, times(1)).deleteById(1L);
    }

    @Test
    void updateMasterByPlanet() {
        when(planetRepoTest.findById(anyLong())).thenReturn(Optional.of(planet));
        when(masterRepoTest.findById(anyLong())).thenReturn(Optional.of(master));
        worldMasterServiceTest.updateMasterByPlanet(updateDto);
        assertEquals(1L, planet.getMaster().getId());
        verify(planetRepoTest, times(1)).findById(anyLong());
        verify(masterRepoTest, times(1)).findById(anyLong());
        verify(masterRepoTest, times(1)).save(any());
    }

    @Test
    void updateMasterByPlanetException() {
        Mockito.when(planetRepoTest.findById(any())).thenReturn(Optional.empty());
        assertThrows(PlanetNotFoundException.class, () -> worldMasterServiceTest.updateMasterByPlanet(updateDto));
        verify(planetRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void updateMasterExceptionByPlanet() {
        Mockito.when(planetRepoTest.findById(any())).thenReturn(Optional.of(planet));
        Mockito.when(masterRepoTest.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(MasterNotFoundException.class, () -> worldMasterServiceTest.updateMasterByPlanet(updateDto));
        verify(masterRepoTest, times(1)).findById(anyLong());
    }

    @Test
    void getSlackers() {
        List<Master> masters = new ArrayList<>();
        when(modelMapper.map(any(), any())).thenReturn(master);
        masters.add(modelMapper.map(masterDto, Master.class));
        when(masterRepoTest.findAll()).thenReturn(masters);
        when(modelMapper.map(any(), any())).thenReturn(masterDto);
        List<MasterDto> returnedMasters = worldMasterServiceTest.getSlackers();
        assertEquals(1, returnedMasters.size());

        master.setPlanets(planets);
        when(modelMapper.map(any(), any())).thenReturn(master);
        masters.add(modelMapper.map(masterDto, Master.class));
        when(masterRepoTest.findAll()).thenReturn(masters);
        when(modelMapper.map(any(), any())).thenReturn(masterDto);
        returnedMasters = worldMasterServiceTest.getSlackers();
        assertEquals(0, returnedMasters.size());
    }

    @Test
    void getTenYoungMasters() {
        List<Master> masters = new ArrayList<>();
        when(modelMapper.map(any(), any())).thenReturn(master);
        masters.add(modelMapper.map(masterDto, Master.class));
        when(masterRepoTest.findAll()).thenReturn(masters);
        when(modelMapper.map(any(), any())).thenReturn(masterDto);
        List<MasterDto> returnedMasters = worldMasterServiceTest.getTenYoungMasters();
        assertEquals(1, returnedMasters.size());
    }
}