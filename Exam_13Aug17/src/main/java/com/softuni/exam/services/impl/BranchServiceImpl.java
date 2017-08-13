package com.softuni.exam.services.impl;

import com.softuni.exam.models.dtos.binding.AddBranchDTO;
import com.softuni.exam.models.dtos.views.BranchDTO;
import com.softuni.exam.models.entities.Branch;
import com.softuni.exam.models.entities.Town;
import com.softuni.exam.repositories.BranchRepository;
import com.softuni.exam.repositories.TownRepository;
import com.softuni.exam.services.api.BranchService;
import com.softuni.exam.services.api.TownService;
import com.softuni.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gery on 13.8.2017 г..
 */
@Service
public class BranchServiceImpl implements BranchService {
    private BranchRepository branchRepo;
    private TownRepository townRepo;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TownRepository townRepo) {
        this.branchRepo = branchRepository;
        this.townRepo = townRepo;
    }


    @Override
    public void save(AddBranchDTO branchDTO) {
        if(!DataValidator.validate(branchDTO)) {
            throw new RuntimeException();
        }
        Town town = this.townRepo.findByName(branchDTO.getTown());
        Branch branch = new Branch();
        branch.setName(branchDTO.getName());
        branch.setTown(town);
        this.branchRepo.save(branch);
    }

    @Override
    public List<BranchDTO> findTopBranches() {
        List<Object[]> branches = this.branchRepo.findAllBranchesWithClientSum();
        List<BranchDTO> result = new ArrayList<>();
        for (Object[] obj : branches) {
            Branch currentBranch = this.branchRepo.findOne((long)obj[0]);
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setName(currentBranch.getName());
            branchDTO.setTownName(currentBranch.getTown().getName());
            if(obj[1] != null) {
                branchDTO.setTotalClients((long)obj[1]);
            }
            result.add(branchDTO);
        }
        return result.stream()
                .sorted((b1, b2) -> Long.compare(b2.getTotalClients(), b1.getTotalClients()))
                .collect(Collectors.toList());
    }
}
