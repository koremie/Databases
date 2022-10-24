package com.lviv.iot.view.tables;

import com.lviv.iot.controller.MenuController;
import com.lviv.iot.domain.Menu;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MenuView implements GeneralView {
    @Autowired
    MenuController menuController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public MenuView() {
        menu = new LinkedHashMap<>();
        menu.put("06", "06 - Table: MENU");
        menu.put("061", "061 - Create Menu");
        menu.put("062", "062 - Update Menu");
        menu.put("063", "063 - Delete Menu");
        menu.put("064", "064 - Find all Menu");
        menu.put("065", "065 - Find Menu by Composite PK");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("061", this::create);
        methodsMenu.put("062", this::update);
        methodsMenu.put("063", this::delete);
        methodsMenu.put("064", this::findAll);
        methodsMenu.put("065", this::findById);
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
        System.out.println("Input 'vending_machine_id': ");
        Integer vendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'slot_number': ");
        Integer slotNumber = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'snack': ");
        Integer snackId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'price_per_unit': ");
        Float pricePerUnit = Float.valueOf(inputScanner.nextLine());
        Menu menu = new Menu(vendingMachineId, slotNumber, snackId, quantity, pricePerUnit);

        try {
            menuController.create(menu);
            System.out.println("Successfully created :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create :`(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'vending_machine_id': ");
        Integer vendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'slot_number': ");
        Integer slotNumber = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'snack': ");
        Integer snackId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'price_per_unit': ");
        Float pricePerUnit = Float.valueOf(inputScanner.nextLine());
        Menu menu = new Menu(vendingMachineId, slotNumber, snackId, quantity, pricePerUnit);

        try {
            menuController.update(Arrays.asList(vendingMachineId, slotNumber), menu);
            System.out.println("Successfully updated :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't update :`(");
        }
    }

    @Override
    public void delete() {
        System.out.println("Input 'vending_machine_id': ");
        Integer vendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'slot_number': ");
        Integer slotNumber = Integer.valueOf(inputScanner.nextLine());

        try {
            menuController.delete(Arrays.asList(vendingMachineId, slotNumber));
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: MENU");
        List<Menu> menus = menuController.findAll();
        for (Menu menu : menus)
            System.out.println(menu);
    }

    @Override
    public void findById() {
        System.out.println("Input 'vending_machine_id': ");
        Integer vendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'slot_number': ");
        Integer slotNumber = Integer.valueOf(inputScanner.nextLine());
        Optional<Menu> menu = menuController.findById(Arrays.asList(vendingMachineId, slotNumber));
        
        if (menu.isPresent()) {
            System.out.println(menu.get());
        } else {
            System.out.println("No such menu :`(");
        }
    }
}