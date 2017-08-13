package com.softuni.exam.terminal.controllers;

import com.softuni.exam.Const;
import com.softuni.exam.io.JsonSerializer;
import com.softuni.exam.io.XMLSerializer;
import com.softuni.exam.models.dtos.binding.EmployeeCardDTO;
import com.softuni.exam.services.api.EmployeeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Controller
public class EmployeeCardController {
    private JsonSerializer jsonSerializer;
    private XMLSerializer xmlSerializer;
    private EmployeeCardService service;

    @Autowired
    public EmployeeCardController(JsonSerializer jsonSerializer, XMLSerializer xmlSerializer, EmployeeCardService service) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.service = service;
    }

    public void importEmployeeCardsFromJson(String path) {
        EmployeeCardDTO[] cards = this.jsonSerializer.deserialize(EmployeeCardDTO[].class, path);
        for (EmployeeCardDTO card : cards) {
            try {
                this.service.save(card);
                System.out.println(String.format(Const.SUCCESSFUL_MESSAGE, "Card", card.getNumber()));
            } catch (Exception e) {
                System.out.println(Const.INVALID_DATA_MESSAGE);
            }
        }
    }

    public void exportFreeCards(String outputPath) {
        List<EmployeeCardDTO> cards = this.service.findAllUnused();
        this.jsonSerializer.serialize(cards,
                EmployeeCardDTO.class, outputPath, "cards");
    }
}
