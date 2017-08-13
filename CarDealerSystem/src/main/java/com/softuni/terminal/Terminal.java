package com.softuni.terminal;

import com.softuni.dto.binding.add.xmlImportDto.ImportXMLCarDTO;
import com.softuni.dto.binding.add.xmlImportDto.ImportXMLCustomerDTO;
import com.softuni.dto.binding.add.xmlImportDto.ImportXMLPartDTO;
import com.softuni.dto.binding.add.xmlImportDto.ImportXMLSupplierDTO;
import com.softuni.dto.binding.idOnly.CarDTO;
import com.softuni.dto.binding.idOnly.CustomerDTO;
import com.softuni.dto.binding.idOnly.PartDTO;
import com.softuni.dto.binding.idOnly.SupplierDTO;
import com.softuni.dto.binding.add.*;
import com.softuni.dto.view.*;
import com.softuni.dto.view.xmlExport.*;
import com.softuni.io.JsonParser;
import com.softuni.io.Parser;
import com.softuni.io.XMLParser;
import com.softuni.services.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created on 4.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {
    private static final String INPUT_PATH = "/files/input/";
    private static final String OUTPUT_PATH = "src/main/resources/files/output/";
    private static final Random RANDOM = new Random();

    private CarService carService;
    private CustomerService customerService;
    private PartService partService;
    private SaleService saleService;
    private SupplierService supplierService;
    private JsonParser jsonParser;
    private XMLParser xmlParser;

    @Autowired
    public Terminal(CarService carService, CustomerService customerService, PartService partService, SaleService saleService, SupplierService supplierService, JsonParser jsonParser, XMLParser xmlParser) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {
        //this.jsonExamples();
        this.xmExamples();
    }

    private void xmExamples() {
        //this.seedTheDatabase();
        //this.orderedCustomers(OUTPUT_PATH, this.xmlParser, ".xml");
        //this.carsFromToyota(OUTPUT_PATH, this.xmlParser, ".xml");
        //this.localSuppliers(OUTPUT_PATH, this.xmlParser, ".xml");
        //this.carsWithTheirListOfParts(OUTPUT_PATH, this.xmlParser, ".xml");
        //this.totalSalesByCustomer(OUTPUT_PATH, this.xmlParser, ".xml");
        this.salesAppliedDiscount(OUTPUT_PATH, this.xmlParser, ".xml");
    }

    private void seedTheDatabase() {
        this.importSupplierFromXML(INPUT_PATH + "suppliers.xml");
        this.importPartsFromXML(INPUT_PATH + "parts.xml");
        this.importCarsFromXML(INPUT_PATH + "cars.xml");
        this.importCustomersFromXML(INPUT_PATH + "customers.xml");
        this.importSales();
    }

    private void importCustomersFromXML(String path) {
        ImportXMLCustomerDTO customers = this.xmlParser.getObject(ImportXMLCustomerDTO.class, path);
        for (AddCustomerDTO customer : customers.getCustomerDTOS()) {
            this.customerService.save(customer);
        }
    }

    private void importCarsFromXML(String path) {
        ImportXMLCarDTO carDTO = this.xmlParser.getObject(ImportXMLCarDTO.class, path);
        List<PartDTO> parts = this.partService.findAll();
        for (AddCarDTO car : carDTO.getAddCarDTOS()) {
            while(car.getParts().size() < 10) {
                int partInd = RANDOM.nextInt(parts.size());
                while(car.getParts().contains(parts.get(partInd))) {
                    partInd = RANDOM.nextInt(parts.size());
                }
                car.addPart(parts.get(partInd));
            }
            this.carService.save(car);
        }
    }

    private void importPartsFromXML(String path) {
        ImportXMLPartDTO partDTO = this.xmlParser.getObject(ImportXMLPartDTO.class, path);
        List<SupplierDTO> suppliers = this.supplierService.findAll();
        for (AddPartDTO part : partDTO.getAddCarDTOS()) {
            part.setSupplier(suppliers.get(RANDOM.nextInt(suppliers.size())));
            this.partService.save(part);
        }
    }

    private void importSupplierFromXML(String path) {
        ImportXMLSupplierDTO supplierDTO = this.xmlParser.getObject(ImportXMLSupplierDTO.class, path);
        for (AddSupplierDTO supplier : supplierDTO.getSuppliers()) {
            this.supplierService.save(supplier);
        }
    }

    private void jsonExamples() {
        this.importData(INPUT_PATH);
        this.orderedCustomers(OUTPUT_PATH, this.jsonParser, ".json");
        this.carsFromToyota(OUTPUT_PATH, this.jsonParser, ".json");
        this.localSuppliers(OUTPUT_PATH, this.jsonParser, ".json");
        this.carsWithTheirListOfParts(OUTPUT_PATH, this.jsonParser, ".json");
        this.totalSalesByCustomer(OUTPUT_PATH, this.jsonParser, ".json");
        this.salesAppliedDiscount(OUTPUT_PATH, this.jsonParser, ".json");
    }

    private void salesAppliedDiscount(String path, Parser parser, String format) {
        String output = path + "q6.6-sales-with-applied-discount" + format;
        List<SaleDetailViewDTO> sales = this.saleService.findSalesWithDetails();
        if(parser instanceof XMLParser) {
            XMLSalesWrapper wrapper = new XMLSalesWrapper();
            wrapper.setSales(sales);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(sales, output);
    }

    private void totalSalesByCustomer(String path, Parser parser, String format) {
        String output = path + "q6.5-total-sales-per-customer" + format;
        List<CustomerDTOWithSales> customers = this.customerService.findCustomersPerSales();
        if(parser instanceof XMLParser) {
            XMLWrapperCustomersWithSales wrapper = new XMLWrapperCustomersWithSales();
            wrapper.setCustomers(customers);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(customers, output);
    }

    private void carsWithTheirListOfParts(String path, Parser parser, String format) {
        String output = path + "q6.4-cars-and-parts" + format;
        List<CarViewDTOWithParts> cars = this.carService.findCarsWithParts();
        if(parser instanceof XMLParser) {
            XMLCarsWitPartsWrapper wrapper = new XMLCarsWitPartsWrapper();
            wrapper.setCars(cars);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(cars, output);
    }

    private void localSuppliers(String path, Parser parser, String format) {
        String output = path + "q6.3-local-suppliers" + format;
        List<Integer> suppliersIds = this.supplierService.findAllIdsOfLocalSuppliers();
        List<SupplierViewDTO> suppliers = this.supplierService.findCountOfProductsBySupplier(suppliersIds);
        if(parser instanceof XMLParser) {
            XMLSuppliersWrapper wrapper = new XMLSuppliersWrapper();
            wrapper.setSuppliers(suppliers);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(suppliers, output);
    }

    private void carsFromToyota(String path, Parser parser, String format) {
        String output = path + "q6.2-cars-from-toyota" + format;
        List<CarViewDTO> cars = this.carService.findOrderedAllByMake("Toyota");
        if(parser instanceof XMLParser) {
            XMLCarsWrapper wrapper = new XMLCarsWrapper();
            wrapper.setCars(cars);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(cars, output);
    }

    private void orderedCustomers(String path, Parser parser, String format) {
        String output = path + "q6.1-ordered-customers" + format;
        List<CustomerViewDTO> customers = this.customerService.findAllOrdered();
        if(parser instanceof XMLParser) {
            XMLCustomerWrapper wrapper = new XMLCustomerWrapper();
            wrapper.setCustomers(customers);
            parser.writeObject(wrapper, output);
            return;
        }
        parser.writeObject(customers, output);
    }

    private void importData(String inputPath) {
        this.importSuppliers(inputPath);
        this.importParts(inputPath);
        this.importCars(inputPath);
        this.importCustomers(inputPath);
        this.importSales();
    }

    private void importSales() {
        double[] discounts = new double[]{0.0, 0.5, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50};
        List<CarDTO> cars = this.carService.findAll();
        List<CustomerDTO> customers = this.customerService.findAll();
        for (int i = 0; i < 30; i++) {
            AddSaleDTO saleDTO = new AddSaleDTO();
            saleDTO.setCar(cars.get(RANDOM.nextInt(cars.size())));
            saleDTO.setCustomer(customers.get(RANDOM.nextInt(customers.size())));
            saleDTO.setDiscount(discounts[RANDOM.nextInt(discounts.length)]);
            this.saleService.save(saleDTO);
        }
    }

    private void importCustomers(String inputPath) {
        AddCustomerDTO[] customers = this.jsonParser.getObject(AddCustomerDTO[].class, inputPath + "customers.json");
        for (AddCustomerDTO customer : customers) {
            this.customerService.save(customer);
        }
    }

    private void importCars(String inputPath) {
        AddCarDTO[] cars = this.jsonParser.getObject(AddCarDTO[].class, inputPath + "cars.json");
        List<PartDTO> parts = this.partService.findAll();
        for (AddCarDTO car : cars) {
            while(car.getParts().size() < 10) {
                int partInd = RANDOM.nextInt(parts.size());
                while(car.getParts().contains(parts.get(partInd))) {
                    partInd = RANDOM.nextInt(parts.size());
                }
                car.addPart(parts.get(partInd));
            }
            this.carService.save(car);
        }
    }

    private void importParts(String inputPath) {
        AddPartDTO[] parts = this.jsonParser.getObject(AddPartDTO[].class, inputPath + "parts.json");
        List<SupplierDTO> suppliers = this.supplierService.findAll();
        for (AddPartDTO part : parts) {
            part.setSupplier(suppliers.get(RANDOM.nextInt(suppliers.size())));
            this.partService.save(part);
        }
    }

    private void importSuppliers(String inputPath) {
        AddSupplierDTO[] suppliers = this.jsonParser.getObject(AddSupplierDTO[].class, inputPath + "suppliers.json");
        for (AddSupplierDTO supplier : suppliers) {
            this.supplierService.save(supplier);
        }
    }


}
