package com.ntiteam.task.controller;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.service.WorldMasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc()
class GrandMasterControllerTest {

    GrandMasterController grandMasterController;

    @Mock
    WorldMasterService worldMasterService;

    MockMvc mockMvc;

    MasterDto masterDto = new MasterDto();
    List<MasterDto> masterDtos = new ArrayList<>();
    PlanetDto planetDto = new PlanetDto();
    List<PlanetDto> planetDtos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        planetDto.setName("TestName");
        planetDto.setId(1L);
        planetDtos.add(planetDto);
        masterDto.setId(1L);
        masterDto.setName("TestName");
        masterDto.setAge(26L);
        masterDtos.add(masterDto);
        grandMasterController = new GrandMasterController(worldMasterService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(grandMasterController)
                .build();
    }

    @Test
    void getAll() throws Exception {
        Mockito.when(worldMasterService.getAll()).thenReturn(masterDtos);
        mockMvc.perform(get("/get/all"))
                .andExpect(status().isOk());
    }

    @Test
    void getMasterById() throws Exception {
        Mockito.when(worldMasterService.getMasterById(anyLong())).thenReturn(masterDto);
        mockMvc.perform(get("/get/master/1"))
                .andExpect(status().isOk());
    }

    @Test
    void addMaster() throws Exception {
        mockMvc.perform(post("/add/master/TestName/26"))
                .andExpect(status().isOk());
    }

    @Test
    void setPlanetToMaster() throws Exception {
        Mockito.when(worldMasterService.updateMasterByPlanet(any())).thenReturn(masterDto);
        mockMvc.perform(post("/edit/master/5/5"))
                .andExpect(status().isOk());
    }

    @Test
    void getSlackers() throws Exception {
        Mockito.when(worldMasterService.getAll()).thenReturn(masterDtos);
        mockMvc.perform(get("/get/masters/slacker"))
                .andExpect(status().isOk());
    }

    @Test
    void getTenYoungMasters() throws Exception {
        Mockito.when(worldMasterService.getAll()).thenReturn(masterDtos);
        mockMvc.perform(get("/get/masters/young"))
                .andExpect(status().isOk());
    }
}