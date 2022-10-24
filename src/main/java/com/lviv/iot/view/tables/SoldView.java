package com.lviv.iot.view.tables;

import com.lviv.iot.controller.SoldController;
import com.lviv.iot.domain.Sold;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SoldView implements GeneralView {
    @Autowired
    SoldController soldController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public SoldView() {
        menu = new LinkedHashMap<>();
        menu.put("11", "11 - Table: SOLD");
        menu.put("111", "111 - Create Sold");
        menu.put("112", "112 - Update Sold");
        menu.put("113", "113 - Delete Sold");
        menu.put("114", "114 - Find all Sold");
        menu.put("115", "115 - Find Sold by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("111", this::create);
        methodsMenu.put("112", this::update);
        methodsMenu.put("113", this::delete);
        methodsMenu.put("114", this::findAll);
        methodsMenu.put("115", this::findById);
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
        System.out.println("Input 'time': ");
        String time = inputScanner.nextLine();
        Sold sold = new Sold(null, menuVendingMachineId, menuSlotNumber, time);

        try {
            soldController.create(sold);
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
        System.out.println("Input 'time': ");
        String time = inputScanner.nextLine();
        Sold sold = new Sold(null, menuVendingMachineId, menuSlotNumber, time);

        try {
            soldController.update(id, sold);
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
            soldController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: SOLD");
        List<Sold> solds = soldController.findAll();
        for (Sold sold : solds)
            System.out.println(sold);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<Sold> sold = soldController.findById(id);

        if (sold.isPresent()) {
            System.out.println(sold.get());
        } else {
            System.out.println("No such sold :`(");
        }
    }
}