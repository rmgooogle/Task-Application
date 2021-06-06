package com.ntiteam.task.service.impl;

import com.ntiteam.task.model.dto.MasterDto;
import com.ntiteam.task.model.dto.PlanetDto;
import com.ntiteam.task.model.entity.Master;
import com.ntiteam.task.model.entity.Planet;
import com.ntiteam.task.exception.MasterNotFoundException;
import com.ntiteam.task.exception.PlanetNotFoundExceprion;
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
        Optional<Master> Master = masterRepo.findById(id);
        if (Master.isEmpty()) {
            throw new MasterNotFoundException("Master not found");
        }
        return modelMapper.map(Master.get(), MasterDto.class);
    }

    @Override
    public PlanetDto getPlanetById(Long id) {
        Optional<Planet> planet = planetRepo.findById(id);
        if (planet.isEmpty()) {
            throw new PlanetNotFoundExceprion("Planet not found");
        }
        return modelMapper.map(planet.get(), PlanetDto.class);
    }

    //TODO need refactoring,
    // if names the same, but ages different then we have more, than 1 name
    @Override
    public void createMaster(String name, Long age) {
        if (masterRepo.findByName(name) != null) {
            if ((masterRepo.findByName(name).getName().equals(name)) &&
                    (masterRepo.findByName(name).getAge() == age)) {
                System.out.println("Master with name " + name + " and age " + age + " is already created");
                return;
            }
        }
        Master master = new Master();
        master.setName(name);
        master.setAge(age);
        masterRepo.save(master);
    }

    @Override
    public PlanetDto createPlanet(String name) {

        if (planetRepo.findByName(name) == null) {
            Planet createdPlanet = new Planet();
            createdPlanet.setName(name);
            planetRepo.save(createdPlanet);
        } else {
            System.out.println("Planet with " + name + " is already created.");
        }
        return modelMapper.map(planetRepo.findByName(name), PlanetDto.class);
    }

    @Override
    public void deletePlanetById(Long id) {
        Optional<Planet> planet = planetRepo.findById(id);
        if (planet.isEmpty()) {
            throw new PlanetNotFoundExceprion("Planet not found");
        }
        planetRepo.deleteById(id);
    }

    @Override
    public MasterDto updateMasterByPlanet(Long idPlanet, Long idMaster) {
        Optional<Planet> planet = planetRepo.findById(idPlanet);
        if (planet.isEmpty()) {
            throw new PlanetNotFoundExceprion("Planet not found");
        }
        Optional<Master> grandMaster = masterRepo.findById(idMaster);
        if (grandMaster.isEmpty()) {
            throw new MasterNotFoundException("Master not found");
        }
        planet.get().setMaster(grandMaster.get());
        masterRepo.save(grandMaster.get());
        return modelMapper.map(grandMaster.get(), MasterDto.class);
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
