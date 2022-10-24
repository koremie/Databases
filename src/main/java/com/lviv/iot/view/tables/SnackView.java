package com.lviv.iot.view.tables;

import com.lviv.iot.controller.SnackController;
import com.lviv.iot.domain.Snack;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SnackView implements GeneralView {
    @Autowired
    SnackController snackController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public SnackView() {
        menu = new LinkedHashMap<>();
        menu.put("10", "10 - Table: SNACK");
        menu.put("101", "101 - Create Snack");
        menu.put("102", "102 - Update Snack");
        menu.put("103", "103 - Delete Snack");
        menu.put("104", "104 - Find all Snack");
        menu.put("105", "105 - Find Snack by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("101", this::create);
        methodsMenu.put("102", this::update);
        methodsMenu.put("103", this::delete);
        methodsMenu.put("104", this::findAll);
        methodsMenu.put("105", this::findById);
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
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();
        System.out.println("Input 'net_weight': ");
        Float netWeight = Float.valueOf(inputScanner.nextLine());
        System.out.println("Input 'trademark_name': ");
        String trademarkName = inputScanner.nextLine();
        Snack snack = new Snack(null, name, netWeight, trademarkName);

        try {
            snackController.create(snack);
            System.out.println("Successfully created :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create :`(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();
        System.out.println("Input 'net_weight': ");
        Float netWeight = Float.valueOf(inputScanner.nextLine());
        System.out.println("Input 'trademark_name': ");
        String trademarkName = inputScanner.nextLine();
        Snack snack = new Snack(null, name, netWeight, trademarkName);

        try {
            snackController.update(id, snack);
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
            snackController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: SNACK");
        List<Snack> snacks = snackController.findAll();
        for (Snack snack : snacks)
            System.out.println(snack);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<Snack> snack = snackController.findById(id);

        if (snack.isPresent()) {
            System.out.println(snack.get());
        } else {
            System.out.println("No such snack :`(");
        }
    }
}
