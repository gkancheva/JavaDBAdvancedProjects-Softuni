package com.softuni.terminal;

import com.softuni.dto.bindingModels.CategoryDTO;
import com.softuni.dto.bindingModels.UserDTO;
import com.softuni.dto.bindingModels.add.AddCategoryDTO;
import com.softuni.dto.bindingModels.add.AddProductDTO;
import com.softuni.dto.bindingModels.add.AddUserDTO;
import com.softuni.dto.bindingModels.add.xmlDtos.CategoryImportXmlDTO;
import com.softuni.dto.bindingModels.add.xmlDtos.ProductImportXmlDTO;
import com.softuni.dto.bindingModels.add.xmlDtos.UserImportXmlDTO;
import com.softuni.dto.viewModel.product.*;
import com.softuni.dto.viewModel.CategoriesDetailInfoDTO;
import com.softuni.dto.viewModel.users.UserViewSoldProductsDTO;
import com.softuni.dto.viewModel.users.UserWithCountOFSoldProductDTO;
import com.softuni.io.JsonParser;
import com.softuni.io.Parser;
import com.softuni.io.XMLParser;
import com.softuni.services.api.CategoryService;
import com.softuni.services.api.ProductService;
import com.softuni.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created on 3.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {
    private static final String FILE_PATH_IN = "/files/input/";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/files/output/";

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;
    private final JsonParser jsonParser;

    private final XMLParser xmlParser;

    @Autowired
    public Terminal(CategoryService categoryService, ProductService productService, UserService userService, JsonParser jsonParser, XMLParser xmlParser) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.jsonExamples(this.jsonParser);
        //this.xmlExamples(this.xmlParser);
    }

    private void xmlExamples(XMLParser parser) {
        String format = ".xml";
        this.seedDBFromXML();
        this.productsInPriceRange(500, 1000, parser, format);
        this.successfullySoldProducts(parser, format);
        this.categoriesByProductsCount(parser, format);
        this.usersAndProducts(parser, format);
    }

    private void seedDBFromXML() {
        this.importUsersFromXML(FILE_PATH_IN + "users.xml");
        this.importCategoriesFromXML(FILE_PATH_IN + "categories.xml");
        this.importProductsFromXML(FILE_PATH_IN + "products.xml");
    }

    private void importProductsFromXML(String path) {
        Random random = new Random();
        ProductImportXmlDTO products = this.xmlParser.getObject(ProductImportXmlDTO.class, path);
        List<UserDTO> userDTOS = this.userService.findAll();
        List<CategoryDTO> categoryDTOS = this.categoryService.findAll();
        for (int i = 0; i < products.getProductsDto().size(); i++) {
            int sellerInd = random.nextInt(userDTOS.size());
            products.getProductsDto().get(i).setSeller(userDTOS.get(sellerInd));
            if (i % 3 != 0) {
                int buyerInd = random.nextInt(userDTOS.size());
                while (buyerInd == sellerInd) {
                    buyerInd = random.nextInt(userDTOS.size());
                }
                products.getProductsDto().get(i).setBuyer(userDTOS.get(buyerInd));
            }
            int categoryInd = random.nextInt(categoryDTOS.size());
            products.getProductsDto().get(i).addCategory(categoryDTOS.get(categoryInd));
            this.productService.save(products.getProductsDto().get(i));
        }
    }

    private void importCategoriesFromXML(String path) {
        CategoryImportXmlDTO categories = null;
        categories = this.xmlParser.getObject(CategoryImportXmlDTO.class, path);
        for (AddCategoryDTO category : categories.getCategoryDTOS()) {
            this.categoryService.save(category);
        }
    }

    private void importUsersFromXML(String path) {
        UserImportXmlDTO userDTO = this.xmlParser.getObject(UserImportXmlDTO.class, path);
        for (AddUserDTO userDto : userDTO.getUserAddDtos()) {
            this.userService.save(userDto);
        }
    }

    private void jsonExamples(JsonParser parser) {
        String format = ".json";
        this.seedDatabase();
        this.productsInPriceRange(500, 1000, parser, format);
        this.successfullySoldProducts(parser, format);
        this.categoriesByProductsCount(parser, format);
        this.usersAndProducts(parser, format);
    }

    private void usersAndProducts(Parser parser, String format) {
        String outputFile = OUTPUT_FILE_PATH + "problem-3.4-users-and-products";
        List<UserWithCountOFSoldProductDTO> users = this.userService.findAllWithCountOfProducts();
        if(parser instanceof XMLParser) {
            XMLWrapperUserWithSold wrapper = new XMLWrapperUserWithSold();
            wrapper.setCount(users.size());
            wrapper.setUsers(users);
            parser.writeObject(wrapper, outputFile + format);
            return;
        }
        parser.writeObject(users, outputFile + format);
    }

    private void categoriesByProductsCount(Parser parser, String format) {
        String outputFile = OUTPUT_FILE_PATH + "problem-3.3-categories-by-products";
        List<CategoriesDetailInfoDTO> categories = this.categoryService.findAllCategoriesSummary();
        if(parser instanceof XMLParser) {
            XMLWrapperCategory wrapper = new XMLWrapperCategory();
            wrapper.setCategories(categories);
            parser.writeObject(wrapper, outputFile + format);
            return;
        }
        parser.writeObject(categories, outputFile + format);
    }

    private void successfullySoldProducts(Parser parser, String format) {
        String outputFile = OUTPUT_FILE_PATH + "problem-3.2-users-sold-products";
        List<UserViewSoldProductsDTO> users = this.userService.findAllWithSoldProducts();
        if(parser instanceof XMLParser) {
            XMLWrapperUser wrapper = new XMLWrapperUser();
            wrapper.setUsers(users);
            parser.writeObject(wrapper, outputFile + format);
            return;
        }
        parser.writeObject(users, outputFile + format);
    }

    private void productsInPriceRange(int min, int max, Parser parser, String format) {
        String outputFile = OUTPUT_FILE_PATH + "problem-3.1-products-in-range";
        List<ProductViewDTOWithSeller> products = this.productService
                .findAllWithPriceBetween(BigDecimal.valueOf(min),BigDecimal.valueOf(max));
        if(parser instanceof XMLParser) {
            XMLWrapperProduct wrapper = new XMLWrapperProduct();
            wrapper.setProducts(products);
            parser.writeObject(wrapper, outputFile + format );
            return;
        }
        parser.writeObject(products, outputFile + format);
    }

    private void seedDatabase() {
        this.importUsersFromFile(FILE_PATH_IN + "users.json");
        this.importCategoriesFromFile(FILE_PATH_IN + "categories.json");
        this.importProductsFromFile(FILE_PATH_IN + "products.json");
    }

    private void importProductsFromFile(String path) {
        Random random = new Random();
        AddProductDTO[] productDTOS = this.jsonParser.getObject(AddProductDTO[].class, path);
        List<UserDTO> userDTOS = this.userService.findAll();
        List<CategoryDTO> categoryDTOS = this.categoryService.findAll();
        for (int i = 0; i < productDTOS.length; i++) {
            int sellerInd = random.nextInt(userDTOS.size());
            productDTOS[i].setSeller(userDTOS.get(sellerInd));
            if(i % 3 != 0) {
                int buyerInd = random.nextInt(userDTOS.size());
                while(buyerInd == sellerInd) {
                    buyerInd = random.nextInt(userDTOS.size());
                }
                productDTOS[i].setBuyer(userDTOS.get(buyerInd));
            }
            int categoryInd = random.nextInt(categoryDTOS.size());
            productDTOS[i].addCategory(categoryDTOS.get(categoryInd));
            this.productService.save(productDTOS[i]);
        }
    }

    private void importCategoriesFromFile(String filePath) {
        AddCategoryDTO[] categoryDTOS = this.jsonParser.getObject(AddCategoryDTO[].class, filePath);
        for (AddCategoryDTO categoryDTO : categoryDTOS) {
            this.categoryService.save(categoryDTO);
        }
    }

    private void importUsersFromFile(String filePath) {
        AddUserDTO[] userDtos = this.jsonParser.getObject(AddUserDTO[].class, filePath);
        for (AddUserDTO userDto : userDtos) {
            this.userService.save(userDto);
        }
    }
}
