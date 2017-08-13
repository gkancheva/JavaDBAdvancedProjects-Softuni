package com.softuni.services.impl;

import com.softuni.dto.binding.idOnly.PartDTO;
import com.softuni.dto.binding.add.AddPartDTO;
import com.softuni.entities.Part;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.PartRepository;
import com.softuni.services.api.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
@Service
public class PartsServiceImpl implements PartService {
    private final PartRepository partRepository;

    @Autowired
    public PartsServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public void save(AddPartDTO partDTO) {
        Part part = DTOConverter.convert(partDTO, Part.class);
        this.partRepository.save(part);
    }

    @Override
    public List<PartDTO> findAll() {
        List<Part> parts = this.partRepository.findAll();
        List<PartDTO> partDTOS = new ArrayList<>();
        for (Part part : parts) {
            partDTOS.add(DTOConverter.convert(part, PartDTO.class));
        }
        return partDTOS;
    }
}
