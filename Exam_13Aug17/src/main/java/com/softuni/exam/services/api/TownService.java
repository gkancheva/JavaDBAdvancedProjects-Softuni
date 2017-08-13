package com.softuni.exam.services.api;

import com.softuni.exam.models.dtos.binding.AddTownDTO;
import com.softuni.exam.models.dtos.views.TownDTO;
import com.softuni.exam.models.entities.Town;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
public interface TownService {
    void save(AddTownDTO townDTO);

    List<TownDTO> findAllBranchesClients();

    Town findByName(String townName);
}
