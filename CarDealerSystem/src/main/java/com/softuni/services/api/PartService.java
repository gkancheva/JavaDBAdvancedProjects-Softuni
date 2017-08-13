package com.softuni.services.api;

import com.softuni.dto.binding.idOnly.PartDTO;
import com.softuni.dto.binding.add.AddPartDTO;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
public interface PartService {
    void save(AddPartDTO partDTO);
    List<PartDTO> findAll();
}
