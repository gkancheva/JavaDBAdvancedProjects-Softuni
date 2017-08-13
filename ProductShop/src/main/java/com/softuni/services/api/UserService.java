package com.softuni.services.api;

import com.softuni.dto.bindingModels.UserDTO;
import com.softuni.dto.bindingModels.add.AddUserDTO;
import com.softuni.dto.viewModel.users.UserViewSoldProductsDTO;
import com.softuni.dto.viewModel.users.UserWithCountOFSoldProductDTO;

import java.util.List;

/**
 * Created on 3.8.2017 г..
 */
public interface UserService {
    void save(AddUserDTO userDTO);
    List<UserDTO> findAll();
    List<UserViewSoldProductsDTO> findAllWithSoldProducts();
    List<UserWithCountOFSoldProductDTO> findAllWithCountOfProducts();
}
