package com.lviv.iot.view.tables;

import com.lviv.iot.controller.AddressController;
import com.lviv.iot.domain.Address;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AddressView implements GeneralView {
    @Autowired
    AddressController addressController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public AddressView() {
        menu = new LinkedHashMap<>();
        menu.put("01", "01 - Table: ADDRESS");
        menu.put("011", "011 - Create Address");
        menu.put("012", "012 - Update Address");
        menu.put("013", "013 - Delete Address");
        menu.put("014", "014 - Find all Address");
        menu.put("015", "015 - Find Address by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("011", this::create);
        methodsMenu.put("012", this::update);
        methodsMenu.put("013", this::delete);
        methodsMenu.put("014", this::findAll);
        methodsMenu.put("015", this::findById);
    }

    @Override
    public Map<String, String> getMenu() {
        return this.menu;
    }

    @Override
    public Map<String, Printable> getMethodsMenu() {
        return this.methodsMenu;
    }

    @Override
    public void create() {
        System.out.println("Input 'city_id': ");
        Integer cityId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'street': ");
        String street = inputScanner.nextLine();
        System.out.println("Input 'house_number': ");
        String houseNumber = inputScanner.nextLine();
        System.out.println("Input 'appartment_number': ");
        Integer appartmentNumber = Integer.valueOf(inputScanner.nextLine());
        Address address = new Address(null, cityId, street, houseNumber, appartmentNumber);

        try {
            addressController.create(address);
            System.out.println("Successfully created)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'city_id': ");
        Integer cityId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'street': ");
        String street = inputScanner.nextLine();
        System.out.println("Input 'house_number': ");
        String houseNumber = inputScanner.nextLine();
        System.out.println("Input 'appartment_number': ");
        Integer appartmentNumber = Integer.valueOf(inputScanner.nextLine());
        Address address = new Address(null, cityId, street, houseNumber, appartmentNumber);

        try {
            addressController.update(id, address);
            System.out.println("Successfully updated :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't update :`(");
        }
    }

    @Override
    public void delete() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());

        try {
            addressController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: ADDRESS");
        List<Address> addresses = addressController.findAll();
        for (Address address : addresses)
            System.out.println(address);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<Address> address = addressController.findById(id);
        if (address.isPresent()) {
            System.out.println(address.get());
        } else {
            System.out.println("No such address :`(");
        }
    }
}
