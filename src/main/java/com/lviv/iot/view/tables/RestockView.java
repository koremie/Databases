package com.lviv.iot.view.tables;

import com.lviv.iot.controller.RestockController;
import com.lviv.iot.domain.Restock;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RestockView implements GeneralView {
    @Autowired
    RestockController restockController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public RestockView() {
        menu = new LinkedHashMap<>();
        menu.put("08", "08 - Table: RESTOCK");
        menu.put("081", "081 - Create Restock");
        menu.put("082", "082 - Update Restock");
        menu.put("083", "083 - Delete Restock");
        menu.put("084", "084 - Find all Restock");
        menu.put("085", "085 - Find Restock by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("081", this::create);
        methodsMenu.put("082", this::update);
        methodsMenu.put("083", this::delete);
        methodsMenu.put("084", this::findAll);
        methodsMenu.put("085", this::findById);
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
        System.out.println("Input 'menu_vending_machine_id': ");
        Integer menuVendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'menu_slot_number': ");
        Integer menuSlotNumber = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'service_staff_id': ");
        Integer serviceStaffId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'date': ");
        String date = inputScanner.nextLine();
        Restock restock = new Restock(null, menuVendingMachineId, menuSlotNumber, quantity, serviceStaffId, date);

        try {
            restockController.create(restock);
            System.out.println("Successfully created :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create :`(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'menu_vending_machine_id': ");
        Integer menuVendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'menu_slot_number': ");
        Integer menuSlotNumber = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'service_staff_id': ");
        Integer serviceStaffId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'date': ");
        String date = inputScanner.nextLine();
        Restock restock = new Restock(null, menuVendingMachineId, menuSlotNumber, quantity, serviceStaffId, date);

        try {
            restockController.update(id, restock);
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
            restockController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: RESTOCK");
        List<Restock> restocks = restockController.findAll();
        for (Restock restock : restocks)
            System.out.println(restock);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<Restock> restock = restockController.findById(id);

        if (restock.isPresent()) {
            System.out.println(restock.get());
        } else {
            System.out.println("No such restock :`(");
        }
    }
}
