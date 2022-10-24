package com.lviv.iot.view.tables;

import com.lviv.iot.controller.MachineModelController;
import com.lviv.iot.domain.MachineModel;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MachineModelView implements GeneralView {
    @Autowired
    MachineModelController machineModelController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public MachineModelView() {
        menu = new LinkedHashMap<>();
        menu.put("05", "05 - Table: MACHINE_MODEL");
        menu.put("051", "051 - Create Machine model");
        menu.put("052", "052 - Update Machine model");
        menu.put("053", "053 - Delete Machine model");
        menu.put("054", "054 - Find all Machine model");
        menu.put("055", "055 - Find Machine model by name");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("051", this::create);
        methodsMenu.put("052", this::update);
        methodsMenu.put("053", this::delete);
        methodsMenu.put("054", this::findAll);
        methodsMenu.put("055", this::findById);
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
        System.out.println("Input 'company': ");
        String company = inputScanner.nextLine();
        MachineModel machineModel = new MachineModel(name, company);

        try {
            machineModelController.create(machineModel);
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
        System.out.println("Input 'company': ");
        String company = inputScanner.nextLine();
        MachineModel machineModel = new MachineModel(newName, company);

        try {
            machineModelController.update(name, machineModel);
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
            machineModelController.delete(name);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: MACHINE_MODEL");
        List<MachineModel> machineModels = machineModelController.findAll();
        for (MachineModel machineModel : machineModels)
            System.out.println(machineModel);
    }

    @Override
    public void findById() {
        System.out.println("Input 'name': ");
        String name = inputScanner.nextLine();
        Optional<MachineModel> machineModel = machineModelController.findById(name);
        if (machineModel.isPresent()) {
            System.out.println(machineModel.get());
        } else {
            System.out.println("No such machine model :`(");
        }
    }
}
