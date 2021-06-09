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
import com.ntiteam.task.service.WorldMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorldMasterServiceImpl implements WorldMasterService {

    private final MasterRepo masterRepo;
    private final PlanetRepo planetRepo;
    private final ModelMapper modelMapper;

    public WorldMasterServiceImpl(
            MasterRepo masterRepo,
            PlanetRepo planetRepo,
            ModelMapper modelMapper
    ) {
        this.masterRepo = masterRepo;
        this.planetRepo = planetRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MasterDto> getAll() {
        return masterRepo.findAll().stream()
                .map(master -> modelMapper.map(master, MasterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MasterDto getMasterById(Long id) {
        Optional<Master> master = masterRepo.findById(id);
        if (master.isEmpty()) {
            throw new MasterNotFoundException("Master not found");
        }
        return modelMapper.map(master.get(), MasterDto.class);
    }

    @Override
    public PlanetDto getPlanetById(Long id) {
        Optional<Planet> planet = planetRepo.findById(id);
        if (planet.isEmpty()) {
            throw new PlanetNotFoundException("Planet not found");
        }
        return modelMapper.map(planet.get(), PlanetDto.class);
    }

    @Override
    public void createMaster(SaveMasterDto dto) {
        masterRepo.save(modelMapper.map(dto, Master.class));
    }

    @Override
    public void createPlanet(String name) {
        planetRepo.save(new Planet(name));
    }

    @Override
    public void deletePlanetById(Long id) {
        Optional<Planet> planet = planetRepo.findById(id);
        if (planet.isEmpty()) {
            throw new PlanetNotFoundException("Planet not found");
        }
        planetRepo.deleteById(id);
    }

    @Override
    public MasterDto updateMasterByPlanet(UpdateDto dto) {
        Optional<Planet> planet = planetRepo.findById(dto.getPlanetId());
        if (planet.isEmpty()) {
            throw new PlanetNotFoundException("Planet not found");
        }
        Optional<Master> master = masterRepo.findById(dto.getMasterId());
        if (master.isEmpty()) {
            throw new MasterNotFoundException("Master not found");
        }
        planet.get().setMaster(master.get());
        masterRepo.save(master.get());
        return modelMapper.map(master.get(), MasterDto.class);
    }

    @Override
    public List<MasterDto> getSlackers() {
        return masterRepo.findAll().stream()
                .filter(i -> i.getPlanets().isEmpty())
                .map(master -> modelMapper.map(master, MasterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MasterDto> getTenYoungMasters() {
        return masterRepo.findAll().stream()
                .sorted(Comparator.comparing(Master::getAge))
                .limit(10)
                .map(master -> modelMapper.map(master, MasterDto.class))
                .collect(Collectors.toList());
    }
}
