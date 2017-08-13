package com.softuni.exam.services.impl;

import com.softuni.exam.models.dtos.binding.AddTownDTO;
import com.softuni.exam.models.dtos.views.TownDTO;
import com.softuni.exam.models.entities.Branch;
import com.softuni.exam.models.entities.Town;
import com.softuni.exam.repositories.BranchRepository;
import com.softuni.exam.repositories.TownRepository;
import com.softuni.exam.services.api.TownService;
import com.softuni.exam.utils.DTOConverter;
import com.softuni.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gery on 13.8.2017 г..
 */
@Service
public class TownServiceImpl implements TownService {
    private TownRepository townRepo;

    @Autowired
    public TownServiceImpl(TownRepository repository) {
        this.townRepo = repository;
    }

    @Override
    public void save(AddTownDTO townDTO) {
        if(!DataValidator.validate(townDTO)) {
            throw new RuntimeException();
        }
        Town town = DTOConverter.convert(townDTO, Town.class);
        this.townRepo.save(town);
    }

    @Override
    public List<TownDTO> findAllBranchesClients() {
        List<Object[]> townsInfo = this.townRepo.findAllTownIdsWithClientSum();
        Map<Long, Long> townsWithTotal = new HashMap<>();
        for (Object[] obj : townsInfo) {
            townsWithTotal.put((long)obj[0], (long)obj[1]);
        }

        List<Town> towns = this.townRepo.findAll();
        List<TownDTO> result = new ArrayList<>();
        for (Town town : towns) {
            TownDTO townDTO = new TownDTO(town.getName(), town.getPopulation());
            if(townsWithTotal.containsKey(town.getId())) {
                townDTO.setTotalClients(townsWithTotal.get(town.getId()));
            }
            result.add(townDTO);
        }
        return result.stream()
                .sorted((t1, t2) -> Long.compare(t2.getTotalClients(), t1.getTotalClients()))
                .collect(Collectors.toList());
    }

    @Override
    public Town findByName(String name) {
        return this.townRepo.findByName(name);
    }
}
