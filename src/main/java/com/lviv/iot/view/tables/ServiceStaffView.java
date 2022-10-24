package com.lviv.iot.view.tables;

import com.lviv.iot.controller.ServiceStaffController;
import com.lviv.iot.domain.ServiceStaff;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ServiceStaffView implements GeneralView {
    @Autowired
    ServiceStaffController serviceStaffController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public ServiceStaffView() {
        menu = new LinkedHashMap<>();
        menu.put("09", "09 - Table: SERVICE_STAFF");
        menu.put("091", "091 - Create Service staff");
        menu.put("092", "092 - Update Service staff");
        menu.put("093", "093 - Delete Service staff");
        menu.put("094", "094 - Find all Service staff");
        menu.put("095", "095 - Find Service member by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("091", this::create);
        methodsMenu.put("092", this::update);
        methodsMenu.put("093", this::delete);
        methodsMenu.put("094", this::findAll);
        methodsMenu.put("095", this::findById);
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
        System.out.println("Input 'last_name': ");
        String lastName = inputScanner.nextLine();
        System.out.println("Input 'work_experience': ");
        String workExperience = inputScanner.nextLine();
        System.out.println("Input 'is_available': ");
        Boolean isAvailable = Boolean.valueOf(inputScanner.nextLine());
        System.out.println("Input 'address_id': ");
        Integer addressId = Integer.valueOf(inputScanner.nextLine());
        ServiceStaff serviceStaff = new ServiceStaff(null, name, lastName, workExperience, isAvailable, addressId);

        try {
            serviceStaffController.create(serviceStaff);
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
        System.out.println("Input 'last_name': ");
        String lastName = inputScanner.nextLine();
        System.out.println("Input 'work_experience': ");
        String workExperience = inputScanner.nextLine();
        System.out.println("Input 'is_available': ");
        Boolean isAvailable = Boolean.valueOf(inputScanner.nextLine());
        System.out.println("Input 'address_id': ");
        Integer addressId = Integer.valueOf(inputScanner.nextLine());
        ServiceStaff serviceStaff = new ServiceStaff(null, name, lastName, workExperience, isAvailable, addressId);

        try {
            serviceStaffController.update(id, serviceStaff);
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
            serviceStaffController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: SERVICE_STAFF");
        List<ServiceStaff> serviceStaffs = serviceStaffController.findAll();
        for (ServiceStaff serviceStaff : serviceStaffs)
            System.out.println(serviceStaff);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<ServiceStaff> serviceStaff = serviceStaffController.findById(id);

        if (serviceStaff.isPresent()) {
            System.out.println(serviceStaff.get());
        } else {
            System.out.println("No such service member :`(");
        }
    }
}
