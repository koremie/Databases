-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-07 19:29:06.895

-- tables
-- Table: adress
CREATE TABLE adress (
    id int NOT NULL AUTO_INCREMENT,
    city_id int NULL,
    street varchar(50) NOT NULL,
    house_number int NULL,
    appartment_number int NULL,
    CONSTRAINT adress_pk PRIMARY KEY (id)
);

-- Table: cash_load
CREATE TABLE cash_load (
    id int NOT NULL AUTO_INCREMENT,
    vending_machine_id int NOT NULL,
    service_staff_id int NOT NULL,
    amount decimal(10,5) NOT NULL,
    date date NOT NULL,
    CONSTRAINT cash_load_pk PRIMARY KEY (id)
);

-- Table: cash_withdrawal
CREATE TABLE cash_withdrawal (
    id int NOT NULL AUTO_INCREMENT,
    vending_machine_id int NOT NULL,
    service_staff_id int NOT NULL,
    amount decimal(10,5) NOT NULL,
    date date NOT NULL,
    CONSTRAINT cash_withdrawal_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    region_id int NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: machine_model
CREATE TABLE machine_model (
    name varchar(50) NOT NULL,
    company varchar(50) NOT NULL,
    CONSTRAINT machine_model_pk PRIMARY KEY (name)
);

-- Table: menu
CREATE TABLE menu (
    vending_machine_id int NOT NULL,
    slot_number int NOT NULL,
    snack_id int NOT NULL,
    quantity int NOT NULL,
    price_per_unit decimal(10,5) NOT NULL,
    CONSTRAINT menu_pk PRIMARY KEY (vending_machine_id,slot_number)
);

-- Table: region
CREATE TABLE region (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    CONSTRAINT region_pk PRIMARY KEY (id)
);

-- Table: restock
CREATE TABLE restock (
    id int NOT NULL AUTO_INCREMENT,
    menu_vending_machine_id int NOT NULL,
    menu_slot_number int NOT NULL,
    quantity int NOT NULL,
    service_staff_id int NOT NULL,
    date date NOT NULL,
    CONSTRAINT restock_pk PRIMARY KEY (id)
);

-- Table: service_staff
CREATE TABLE service_staff (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    work_experience varchar(10) NULL,
    is_available bool NOT NULL,
    adress_id int NOT NULL,
    CONSTRAINT service_staff_pk PRIMARY KEY (id)
);

-- Table: snack
CREATE TABLE snack (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    net_weight float NOT NULL,
    trademark_name varchar(50) NOT NULL,
    CONSTRAINT snack_pk PRIMARY KEY (id)
);

-- Table: sold
CREATE TABLE sold (
    id int NOT NULL AUTO_INCREMENT,
    menu_vending_machine_id int NOT NULL,
    menu_slot_number int NOT NULL,
    time timestamp NOT NULL,
    CONSTRAINT sold_pk PRIMARY KEY (id)
);

-- Table: trademark
CREATE TABLE trademark (
    name varchar(50) NOT NULL,
    CONSTRAINT trademark_pk PRIMARY KEY (name)
);

-- Table: vending_machine
CREATE TABLE vending_machine (
    id int NOT NULL AUTO_INCREMENT,
    machine_model_name varchar(50) NOT NULL,
    gps varchar(50) NOT NULL,
    adress_id int NULL,
    contact_number varchar(13) NULL,
    is_out_of_order bool NOT NULL DEFAULT false,
    is_empty bool NOT NULL,
    CONSTRAINT vending_machine_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: adress_city (table: adress)
ALTER TABLE adress ADD CONSTRAINT adress_city FOREIGN KEY adress_city (city_id)
    REFERENCES city (id);

-- Reference: cash_load_service_staff (table: cash_load)
ALTER TABLE cash_load ADD CONSTRAINT cash_load_service_staff FOREIGN KEY cash_load_service_staff (service_staff_id)
    REFERENCES service_staff (id);

-- Reference: cash_load_vending_machine (table: cash_load)
ALTER TABLE cash_load ADD CONSTRAINT cash_load_vending_machine FOREIGN KEY cash_load_vending_machine (vending_machine_id)
    REFERENCES vending_machine (id);

-- Reference: cash_withdrawal_service_staff (table: cash_withdrawal)
ALTER TABLE cash_withdrawal ADD CONSTRAINT cash_withdrawal_service_staff FOREIGN KEY cash_withdrawal_service_staff (service_staff_id)
    REFERENCES service_staff (id);

-- Reference: cash_withdrawal_vending_machine (table: cash_withdrawal)
ALTER TABLE cash_withdrawal ADD CONSTRAINT cash_withdrawal_vending_machine FOREIGN KEY cash_withdrawal_vending_machine (vending_machine_id)
    REFERENCES vending_machine (id);

-- Reference: city_region (table: city)
ALTER TABLE city ADD CONSTRAINT city_region FOREIGN KEY city_region (region_id)
    REFERENCES region (id);

-- Reference: menu_snack (table: menu)
ALTER TABLE menu ADD CONSTRAINT menu_snack FOREIGN KEY menu_snack (snack_id)
    REFERENCES snack (id);

-- Reference: menu_vending_machine (table: menu)
ALTER TABLE menu ADD CONSTRAINT menu_vending_machine FOREIGN KEY menu_vending_machine (vending_machine_id)
    REFERENCES vending_machine (id);

-- Reference: restock_menu (table: restock)
ALTER TABLE restock ADD CONSTRAINT restock_menu FOREIGN KEY restock_menu (menu_vending_machine_id,menu_slot_number)
    REFERENCES menu (vending_machine_id,slot_number);

-- Reference: restock_service_staff (table: restock)
ALTER TABLE restock ADD CONSTRAINT restock_service_staff FOREIGN KEY restock_service_staff (service_staff_id)
    REFERENCES service_staff (id);

-- Reference: service_staff_adress (table: service_staff)
ALTER TABLE service_staff ADD CONSTRAINT service_staff_adress FOREIGN KEY service_staff_adress (adress_id)
    REFERENCES adress (id);

-- Reference: snack_trademark (table: snack)
ALTER TABLE snack ADD CONSTRAINT snack_trademark FOREIGN KEY snack_trademark (trademark_name)
    REFERENCES trademark (name);

-- Reference: sold_menu (table: sold)
ALTER TABLE sold ADD CONSTRAINT sold_menu FOREIGN KEY sold_menu (menu_vending_machine_id,menu_slot_number)
    REFERENCES menu (vending_machine_id,slot_number);

-- Reference: vending_machine_adress (table: vending_machine)
ALTER TABLE vending_machine ADD CONSTRAINT vending_machine_adress FOREIGN KEY vending_machine_adress (adress_id)
    REFERENCES adress (id);

-- Reference: vending_machine_machine_model (table: vending_machine)
ALTER TABLE vending_machine ADD CONSTRAINT vending_machine_machine_model FOREIGN KEY vending_machine_machine_model (machine_model_name)
    REFERENCES machine_model (name);

-- End of file.

