package com.lviv.iot.view.tables;

import com.lviv.iot.controller.VendingMachineController;
import com.lviv.iot.domain.VendingMachine;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VendingMachineView implements GeneralView {
    @Autowired
    VendingMachineController vendingMachineController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public VendingMachineView() {
        menu = new LinkedHashMap<>();
        menu.put("13", "13 - Table: VENDING_MACHINE");
        menu.put("131", "131 - Create Vending machine");
        menu.put("132", "132 - Update Vending machine");
        menu.put("133", "133 - Delete Vending machine");
        menu.put("134", "134 - Find all Vending machine");
        menu.put("135", "135 - Find Vending machine by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("131", this::create);
        methodsMenu.put("132", this::update);
        methodsMenu.put("133", this::delete);
        methodsMenu.put("134", this::findAll);
        methodsMenu.put("135", this::findById);
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
        System.out.println("Input 'machine_model_name': ");
        String machineModelName = inputScanner.nextLine();
        System.out.println("Input 'gps': ");
        String GPS = inputScanner.nextLine();
        System.out.println("Input 'address_id': ");
        Integer addressId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'contact_number': ");
        String contactNumber = inputScanner.nextLine();
        System.out.println("Input 'is_out_of_order': ");
        Boolean isOutOfOrder = Boolean.valueOf(inputScanner.nextLine());
        System.out.println("Input 'is_empty': ");
        Boolean isEmpty = Boolean.valueOf(inputScanner.nextLine());
        VendingMachine vendingMachine = new VendingMachine(null, machineModelName, GPS, addressId, contactNumber,
                isOutOfOrder, isEmpty);

        try {
            vendingMachineController.create(vendingMachine);
            System.out.println("Successfully created :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create :`(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'machine_model_name': ");
        String machineModelName = inputScanner.nextLine();
        System.out.println("Input 'gps': ");
        String GPS = inputScanner.nextLine();
        System.out.println("Input 'address_id': ");
        Integer addressId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'contact_number': ");
        String contactNumber = inputScanner.nextLine();
        System.out.println("Input 'is_out_of_order': ");
        Boolean isOutOfOrder = Boolean.valueOf(inputScanner.nextLine());
        System.out.println("Input 'is_empty': ");
        Boolean isEmpty = Boolean.valueOf(inputScanner.nextLine());
        VendingMachine vendingMachine = new VendingMachine(null, machineModelName, GPS, addressId, contactNumber,
                isOutOfOrder, isEmpty);

        try {
            vendingMachineController.update(id, vendingMachine);
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
            vendingMachineController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: VENDING_MACHINE");
        List<VendingMachine> vendingMachines = vendingMachineController.findAll();
        for (VendingMachine vendingMachine : vendingMachines)
            System.out.println(vendingMachine);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<VendingMachine> vendingMachine = vendingMachineController.findById(id);

        if (vendingMachine.isPresent()) {
            System.out.println(vendingMachine.get());
        } else {
            System.out.println("No such vending machine :`(");
        }
    }
}