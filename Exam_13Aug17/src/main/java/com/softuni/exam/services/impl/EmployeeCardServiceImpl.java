package com.softuni.exam.services.impl;

import com.softuni.exam.models.dtos.binding.EmployeeCardDTO;
import com.softuni.exam.models.entities.EmployeeCard;
import com.softuni.exam.repositories.EmployeeCardRepository;
import com.softuni.exam.services.api.EmployeeCardService;
import com.softuni.exam.utils.DTOConverter;
import com.softuni.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gery on 13.8.2017 г..
 */
@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private EmployeeCardRepository repository;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(EmployeeCardDTO cardDTO) {
        if(!DataValidator.validate(cardDTO)) {
            throw new RuntimeException();
        }
        EmployeeCard card = DTOConverter.convert(cardDTO, EmployeeCard.class);
        this.repository.save(card);
    }

    @Override
    public List<EmployeeCardDTO> findAllUnused() {
        List<Integer> usedCardIds = this.repository.findAllCardsIdsInUse();
        List<EmployeeCard> cards = this.repository.findAllUnused(usedCardIds);
        return cards.stream()
                .sorted(Comparator.comparingLong(EmployeeCard::getId))
                .map(c -> DTOConverter.convert(c, EmployeeCardDTO.class))
                .collect(Collectors.toList());
    }
}
