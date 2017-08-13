package com.softuni.exam.terminal.controllers;

import com.softuni.exam.Const;
import com.softuni.exam.io.JsonSerializer;
import com.softuni.exam.io.XMLSerializer;
import com.softuni.exam.models.dtos.binding.AddTownDTO;
import com.softuni.exam.models.dtos.views.TownDTO;
import com.softuni.exam.services.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Controller
public class TownController {
    private JsonSerializer jsonSerializer;
    private XMLSerializer xmlSerializer;
    private TownService townService;

    @Autowired
    public TownController(JsonSerializer jsonSerializer, XMLSerializer xmlSerializer, TownService townService) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.townService = townService;
    }

    public void importTownsFromJson(String path) {
        AddTownDTO[] towns = this.jsonSerializer.deserialize(AddTownDTO[].class, path);
        for (AddTownDTO town : towns) {
            try {
                this.townService.save(town);
                System.out.println(String.format(
                        Const.SUCCESSFUL_MESSAGE, "Town", town.getName()));
            } catch (Exception e) {
                System.out.println(Const.INVALID_DATA_MESSAGE);;
            }
        }
    }

    public void exportTowns(String path) {
        List<TownDTO> towns = this.townService.findAllBranchesClients();
        this.xmlSerializer.serialize(towns, TownDTO.class, path, "towns");
    }
}
