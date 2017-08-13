package com.softuni.exam.services.api;

import com.softuni.exam.models.dtos.binding.AddBranchDTO;
import com.softuni.exam.models.dtos.views.BranchDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by gery on 13.8.2017 г..
 */
public interface BranchService {
    void save(AddBranchDTO branch);

    List<BranchDTO> findTopBranches();
}
