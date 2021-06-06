package com.ntiteam.task.bootstrap;

import com.ntiteam.task.model.entity.Master;
import com.ntiteam.task.model.entity.Planet;
import com.ntiteam.task.repository.MasterRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MasterRepo masterRepo;

    public DataLoader(MasterRepo masterRepo) {
        this.masterRepo = masterRepo;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Master gast = new Master();
        gast.setAge(14000000L);
        gast.setName("Эн Дви Гаст");

        Planet sakaar = new Planet();
        sakaar.setName("Sakaar");
        sakaar.setMaster(gast);
        gast.getPlanets().add(sakaar);

        Master lokiIsAlive = new Master();
        lokiIsAlive.setAge(1052L);
        lokiIsAlive.setName("Локи");

        Planet youta = new Planet();
        youta.setName("Йотунхейм");
        youta.setMaster(lokiIsAlive);
        lokiIsAlive.getPlanets().add(youta);
        masterRepo.save(gast);
        masterRepo.save(lokiIsAlive);

        Master newMaster = new Master();
        newMaster.setAge(22L);
        newMaster.setName("newMaster");

        Planet earth = new Planet();
        earth.setName("Earth");
        earth.setMaster(newMaster);
        newMaster.getPlanets().add(earth);

        Planet moon = new Planet();
        moon.setName("moon");
        moon.setMaster(newMaster);
        newMaster.getPlanets().add(moon);
        masterRepo.save(newMaster);

        Master slacker = new Master();
        slacker.setAge(333L);
        slacker.setName("Slacker");
        masterRepo.save(slacker);
    }
}
