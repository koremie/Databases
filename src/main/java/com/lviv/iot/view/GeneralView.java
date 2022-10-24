package com.lviv.iot.view;

import java.util.Map;

public interface GeneralView {
    Map<String, String> getMenu();

    Map<String, Printable> getMethodsMenu();

    void create();

    void update();

    void delete();

    void findAll();

    void findById();
}