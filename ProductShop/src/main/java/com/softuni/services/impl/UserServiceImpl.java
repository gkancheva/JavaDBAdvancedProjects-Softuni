package com.softuni.services.impl;

import com.softuni.dto.bindingModels.UserDTO;
import com.softuni.dto.bindingModels.add.AddUserDTO;
import com.softuni.dto.viewModel.product.ProductViewDTO;
import com.softuni.dto.viewModel.product.SoldProductsDTO;
import com.softuni.dto.viewModel.users.UserViewSoldProductsDTO;
import com.softuni.dto.viewModel.users.UserWithCountOFSoldProductDTO;
import com.softuni.entities.Product;
import com.softuni.entities.User;
import com.softuni.io.DTOConverter;
import com.softuni.repositories.UserRepository;
import com.softuni.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(AddUserDTO userDTO) {
        User user  = DTOConverter.convert(userDTO, User.class);
        this.userRepo.saveAndFlush(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = this.userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(DTOConverter.convert(user, UserDTO.class));
        }
        return userDTOS;
    }

    @Override
    public List<UserViewSoldProductsDTO> findAllWithSoldProducts() {
        List<User> users = this.userRepo.findAllWithSoldProducts();
        List<UserViewSoldProductsDTO> usersDto = new ArrayList<>();
        for (User user : users) {
            user.setProducts(user.findSoldProducts());
            usersDto.add(DTOConverter.convert(user, UserViewSoldProductsDTO.class));
        }
        return usersDto;
    }

    @Override
    public List<UserWithCountOFSoldProductDTO> findAllWithCountOfProducts() {
        List<User> users = this.userRepo.findAllWithSoldProductOrder();
        List<UserWithCountOFSoldProductDTO> resultUsers = new ArrayList<>();
        for (User user : users) {
            UserWithCountOFSoldProductDTO currentUser = new UserWithCountOFSoldProductDTO();
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setAge(user.getAge());
            SoldProductsDTO soldProducts = new SoldProductsDTO();
            soldProducts.setCount(user.getProducts().size());
            for (Product product : user.getProducts()) {
                soldProducts.addProduct(new ProductViewDTO(product.getName(), product.getPrice()));
            }
            currentUser.setSoldProducts(soldProducts);
            resultUsers.add(currentUser);
        }
        return resultUsers;
    }


}