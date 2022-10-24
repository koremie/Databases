package com.lviv.iot.view.tables;

import com.lviv.iot.controller.TrademarkController;
import com.lviv.iot.domain.Trademark;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TrademarkView implements GeneralView {
    @Autowired
    TrademarkController trademarkController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public TrademarkView() {
        menu = new LinkedHashMap<>();
        menu.put("12", "12 - Table: TRADEMARK");
        menu.put("121", "121 - Create Trademark");
        menu.put("122", "122 - Update Trademark");
        menu.put("123", "123 - Delete Trademark");
        menu.put("124", "124 - Find all Trademark");
        menu.put("125", "125 - Find Trademark by name");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("121", this::create);
        methodsMenu.put("122", this::update);
        methodsMenu.put("123", this::delete);
        methodsMenu.put("124", this::findAll);
        methodsMenu.put("125", this::findById);
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
        Trademark trademark = new Trademark(name);

        try {
            trademarkController.create(trademark);
            System.out.println("Successfully created)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();
        System.out.println("Input new 'name': ");
        String newName = inputScanner.nextLine();
        Trademark trademark = new Trademark(newName);

        try {
            trademarkController.update(name, trademark);
            System.out.println("Successfully updated :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't update :`(");
        }
    }

    @Override
    public void delete() {
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();

        try {
            trademarkController.delete(name);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: TRADEMARK");
        List<Trademark> trademarks = trademarkController.findAll();
        for (Trademark trademark : trademarks) {
            System.out.println(trademark);
        }
    }

    @Override
    public void findById() {
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();
        Optional<Trademark> trademark = trademarkController.findById(name);
        if (trademark.isPresent()) {
            System.out.println(trademark.get());
        } else {
            System.out.println("No such trademark :`(");
        }
    }
}
