package com.softuni.services.impl;

import com.softuni.dto.binding.add.AddCarDTO;
import com.softuni.dto.binding.idOnly.CarDTO;
import com.softuni.dto.view.CarViewDTO;
import com.softuni.dto.view.CarViewDTOWithParts;
import com.softuni.entities.Car;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.CarRepository;
import com.softuni.services.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 4.8.2017 г..
 */
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(AddCarDTO carDTO) {
        Car car = DTOConverter.convert(carDTO, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public List<CarDTO> findAll() {
        List<Car> cars = this.carRepository.findAll();
        List<CarDTO> resultCars = new ArrayList<>();
        for (Car car : cars) {
            resultCars.add(DTOConverter.convert(car, CarDTO.class));
        }
        return resultCars;
    }

    @Override
    public List<CarViewDTO> findOrderedAllByMake(String make) {
        List<Car> cars = this.carRepository.findOrderedAllCarsFromMake(make);
        List<CarViewDTO> resultCars = new ArrayList<>();
        cars.stream()
                .map(c -> DTOConverter.convert(c, CarViewDTO.class))
                .forEach(resultCars::add);
        return resultCars;
    }

    @Override
    public List<CarViewDTOWithParts> findCarsWithParts() {
        List<Car> cars = this.carRepository.findAllWithParts();
        return cars.stream()
                .map(c -> DTOConverter.convert(c, CarViewDTOWithParts.class))
                .collect(Collectors.toList());
    }
}
