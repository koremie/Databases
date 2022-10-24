package com.lviv.iot.view.tables;

import com.lviv.iot.controller.CashWithdrawalController;
import com.lviv.iot.domain.CashWithdrawal;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CashWithdrawalView implements GeneralView {
    @Autowired
    CashWithdrawalController cashWithdrawalController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public CashWithdrawalView() {
        menu = new LinkedHashMap<>();
        menu.put("03", "03 - Table: CASH_WITHDRAWAL");
        menu.put("031", "031 - Create Cash-withdrawal");
        menu.put("032", "032 - Update Cash-withdrawal");
        menu.put("033", "033 - Delete Cash-withdrawal");
        menu.put("034", "034 - Find all Cash-withdrawal");
        menu.put("035", "035 - Find Cash-withdrawal by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("031", this::create);
        methodsMenu.put("032", this::update);
        methodsMenu.put("033", this::delete);
        methodsMenu.put("034", this::findAll);
        methodsMenu.put("035", this::findById);
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
        CashWithdrawal cashLoad = new CashWithdrawal(null, vendingMachineId, serviceStaffId, amount, date);

        try {
            cashWithdrawalController.create(cashLoad);
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
        CashWithdrawal cashLoad = new CashWithdrawal(null, vendingMachineId, serviceStaffId, amount, date);

        try {
            cashWithdrawalController.update(id, cashLoad);
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
            cashWithdrawalController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: CASH_WITHDRAWAL");
        List<CashWithdrawal> cashWithdrawals = cashWithdrawalController.findAll();

        for (CashWithdrawal cashWithdrawal : cashWithdrawals)
            System.out.println(cashWithdrawal);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<CashWithdrawal> cashWithdrawal = cashWithdrawalController.findById(id);

        if (cashWithdrawal.isPresent()) {
            System.out.println(cashWithdrawal.get());
        } else {
            System.out.println("No such cash-withdrawal :`(");
        }
    }
}
