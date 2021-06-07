package com.ntiteam.task.controller;

import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.service.WorldMasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc()
class PlanetControllerTest {

    PlanetController planetController;

    @Mock
    WorldMasterService worldMasterService;

    MockMvc mockMvc;
    PlanetDto planetDto = new PlanetDto();

    @BeforeEach
    void setUp() {
        planetController = new PlanetController(worldMasterService);
        planetDto.setName("TestName");
        planetDto.setId(1L);

        mockMvc = MockMvcBuilders
                .standaloneSetup(planetController)
                .build();
    }

    @Test
    void getPlanetById() throws Exception {
        Mockito.when(worldMasterService.getPlanetById(anyLong())).thenReturn(planetDto);
        mockMvc.perform(get("/get/planet/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createPlanet() throws Exception {
        mockMvc.perform(post("/add/planet/TestName"))
                .andExpect(status().isOk());
    }

    @Test
    void deletePlanetById() throws Exception {
        mockMvc.perform(delete("/delete/planet/1"))
                .andExpect(status().isOk());
    }
}