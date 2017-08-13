package com.softuni.exam.terminal.controllers;

import com.softuni.exam.Const;
import com.softuni.exam.io.JsonSerializer;
import com.softuni.exam.io.XMLSerializer;
import com.softuni.exam.models.dtos.binding.AddBranchDTO;
import com.softuni.exam.models.dtos.views.BranchDTO;
import com.softuni.exam.services.api.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by gery on 13.8.2017 г..
 */
@Controller
public class BranchController {
    private JsonSerializer jsonSerializer;
    private XMLSerializer xmlSerializer;
    private BranchService branchService;

    @Autowired
    public BranchController(JsonSerializer jsonSerializer, XMLSerializer xmlSerializer, BranchService branchService) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.branchService = branchService;
    }

    public void importBranchesFromJson(String path) {
        AddBranchDTO[] branches = this.jsonSerializer.deserialize(AddBranchDTO[].class, path);
        for (AddBranchDTO branch : branches) {
            try {
                this.branchService.save(branch);
                System.out.println(String.format(Const.SUCCESSFUL_MESSAGE, "Branch", branch.getName()));
            } catch (Exception e) {
                System.out.println(Const.INVALID_DATA_MESSAGE);
            }
        }
    }

    public void exportTopBranches(String outputPath) {
        List<BranchDTO> topBranches = this.branchService.findTopBranches();
        this.xmlSerializer.serialize(topBranches,
                BranchDTO.class, outputPath, "branches");
    }
}
