package com.lviv.iot.view.tables;

import com.lviv.iot.controller.CashLoadController;
import com.lviv.iot.domain.CashLoad;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CashLoadView implements GeneralView {
    @Autowired
    CashLoadController cashLoadController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public CashLoadView() {
        menu = new LinkedHashMap<>();
        menu.put("02", "02 - Table: CASH_LOAD");
        menu.put("021", "021 - Create Cash-load");
        menu.put("022", "022 - Update Cash-load");
        menu.put("023", "023 - Delete Cash-load");
        menu.put("024", "024 - Find all Cash-load");
        menu.put("025", "025 - Find Cash-load by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("021", this::create);
        methodsMenu.put("022", this::update);
        methodsMenu.put("023", this::delete);
        methodsMenu.put("024", this::findAll);
        methodsMenu.put("025", this::findById);
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
        System.out.println("Input 'service_staff_id': ");
        Integer serviceStaffId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'amount': ");
        Float amount = Float.valueOf(inputScanner.nextLine());
        System.out.println("Input 'date': ");
        String date = inputScanner.nextLine();
        CashLoad cashLoad = new CashLoad(null, vendingMachineId, serviceStaffId, amount, date);

        try {
            cashLoadController.create(cashLoad);
            System.out.println("Successfully created)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't create(");
        }
    }

    @Override
    public void update() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'vending_machine_id': ");
        Integer vendingMachineId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'service_staff_id': ");
        Integer serviceStaffId = Integer.valueOf(inputScanner.nextLine());
        System.out.println("Input 'amount': ");
        Float amount = Float.valueOf(inputScanner.nextLine());
        System.out.println("Input 'date': ");
        String date = inputScanner.nextLine();
        CashLoad cashLoad = new CashLoad(null, vendingMachineId, serviceStaffId, amount, date);

        try {
            cashLoadController.update(id, cashLoad);
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
            cashLoadController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: CASH_LOAD");
        List<CashLoad> cashLoads = cashLoadController.findAll();

        for (CashLoad cashLoad : cashLoads)
            System.out.println(cashLoad);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<CashLoad> cashLoad = cashLoadController.findById(id);

        if (cashLoad.isPresent()) {
            System.out.println(cashLoad.get());
        } else {
            System.out.println("No such cash-load :`(");
        }
    }
}
