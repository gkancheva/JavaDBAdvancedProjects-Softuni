package com.softuni.services.api;

import com.softuni.dto.binding.add.AddCarDTO;
import com.softuni.dto.binding.idOnly.CarDTO;
import com.softuni.dto.view.CarViewDTO;
import com.softuni.dto.view.CarViewDTOWithParts;

import java.util.List;

/**
 * Created on 4.8.2017 г..
 */
public interface CarService {
    void save(AddCarDTO carDTO);
    List<CarDTO> findAll();
    List<CarViewDTO> findOrderedAllByMake(String make);
    List<CarViewDTOWithParts> findCarsWithParts();
}
