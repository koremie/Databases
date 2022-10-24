package com.lviv.iot.view.tables;

import com.lviv.iot.controller.RegionController;
import com.lviv.iot.domain.Region;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RegionView implements GeneralView {
    @Autowired
    RegionController regionController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public RegionView() {
        menu = new LinkedHashMap<>();
        menu.put("07", "07 - Table: REGION");
        menu.put("071", "071 - Create Region");
        menu.put("072", "072 - Update Region");
        menu.put("073", "073 - Delete Region");
        menu.put("074", "074 - Find all Region");
        menu.put("075", "075 - Find Region by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("071", this::create);
        methodsMenu.put("072", this::update);
        methodsMenu.put("073", this::delete);
        methodsMenu.put("074", this::findAll);
        methodsMenu.put("075", this::findById);
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
        Region region = new Region(null, name);

        try {
            regionController.create(region);
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
        Region region = new Region(null, name);

        try {
            regionController.update(id, region);
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
            regionController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: REGION");
        List<Region> regions = regionController.findAll();
        for (Region region : regions)
            System.out.println(region);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<Region> region = regionController.findById(id);
        
        if (region.isPresent()) {
            System.out.println(region.get());
        } else {
            System.out.println("No such region :`(");
        }
    }
}
