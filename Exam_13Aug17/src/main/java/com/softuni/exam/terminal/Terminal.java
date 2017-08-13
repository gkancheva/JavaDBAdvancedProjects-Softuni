package com.softuni.exam.terminal;

import com.softuni.exam.terminal.controllers.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by gery on 12.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {
    private static final String IN_PATH = "/files/input/";
    private static final String OUT_PATH = "src/main/resources/files/output/";

    private final BranchController branchController;
    private final EmployeeCardController cardController;
    private final EmployeeController employeeController;
    private final ProductController productController;
    private final TownController townController;

    public Terminal(BranchController branchController, EmployeeCardController cardController, EmployeeController employeeController, ProductController productController, TownController townController) {
        this.branchController = branchController;
        this.cardController = cardController;
        this.employeeController = employeeController;
        this.productController = productController;
        this.townController = townController;
    }

    @Override
    public void run(String... strings) throws Exception {
        importData();
        exportData();
    }

    private void exportData() {
        this.cardController.exportFreeCards(OUT_PATH + "free-cards.json");
        this.employeeController.exportProductiveEmployees(OUT_PATH + "productive-employees.json");
        this.townController.exportTowns(OUT_PATH + "towns.xml");
        this.branchController.exportTopBranches(OUT_PATH + "top-branches.xml");
    }

    private void importData() {
        this.townController.importTownsFromJson(IN_PATH + "towns.json");
        this.branchController.importBranchesFromJson(IN_PATH + "branches.json");
        this.cardController.importEmployeeCardsFromJson(IN_PATH + "employee_cards.json");
        this.productController.importProductsFromXML(IN_PATH + "products.xml");
        this.employeeController.importEmployeesFromXML(IN_PATH + "employees.xml");
    }

}