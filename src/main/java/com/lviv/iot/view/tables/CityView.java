package com.lviv.iot.view.tables;

import com.lviv.iot.controller.CityController;
import com.lviv.iot.domain.City;
import com.lviv.iot.view.GeneralView;
import com.lviv.iot.view.Printable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CityView implements GeneralView {
    @Autowired
    CityController cityController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner inputScanner = new Scanner(System.in);

    public CityView() {
        menu = new LinkedHashMap<>();
        menu.put("04", "04 - Table: CITY");
        menu.put("041", "041 - Create City");
        menu.put("042", "042 - Update City");
        menu.put("043", "043 - Delete City");
        menu.put("044", "044 - Find all City");
        menu.put("045", "045 - Find City by ID");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("041", this::create);
        methodsMenu.put("042", this::update);
        methodsMenu.put("043", this::delete);
        methodsMenu.put("044", this::findAll);
        methodsMenu.put("045", this::findById);
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
        System.out.println("Input 'region_id': ");
        Integer regionId = Integer.valueOf(inputScanner.nextLine());
        City city = new City(null, name, regionId);

        try {
            cityController.create(city);
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
        System.out.println("Input 'region_id': ");
        Integer regionId = Integer.valueOf(inputScanner.nextLine());
        City city = new City(null, name, regionId);

        try {
            cityController.update(id, city);
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
            cityController.delete(id);
            System.out.println("Successfully deleted :-)");
        } catch (DataIntegrityViolationException exception) {
            System.out.println("Couldn't delete :`(");
        }
    }

    @Override
    public void findAll() {
        System.out.println("\nTable: CITY");
        List<City> cities = cityController.findAll();
        for (City city : cities)
            System.out.println(city);
    }

    @Override
    public void findById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(inputScanner.nextLine());
        Optional<City> city = cityController.findById(id);

        if (city.isPresent()) {
            System.out.println(city.get());
        } else {
            System.out.println("No such city :`(");
        }
    }
}
