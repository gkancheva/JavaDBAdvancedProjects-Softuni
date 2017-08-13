package com.softuni.exam.terminal.controllers;

import com.softuni.exam.Const;
import com.softuni.exam.io.JsonSerializer;
import com.softuni.exam.io.XMLSerializer;
import com.softuni.exam.models.dtos.binding.AddProductDTO;
import com.softuni.exam.models.dtos.binding.ImportXMLProductsDTO;
import com.softuni.exam.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by gery on 13.8.2017 г..
 */
@Controller
public class ProductController {
    private JsonSerializer jsonSerializer;
    private XMLSerializer xmlSerializer;
    private ProductService service;

    @Autowired
    public ProductController(JsonSerializer jsonSerializer, XMLSerializer xmlSerializer, ProductService service) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.service = service;
    }

    public void importProductsFromXML(String path) {
        ImportXMLProductsDTO productsDTO = this.xmlSerializer.deserialize(ImportXMLProductsDTO.class, path);
        for (AddProductDTO product : productsDTO.getProducts()) {
            try {
                this.service.save(product);
                System.out.println(String.format(
                        Const.SUCCESSFUL_MESSAGE, "Product", product.getName()));
            } catch (Exception e) {
                System.out.println(Const.INVALID_DATA_MESSAGE);
            }
        }
    }
}
