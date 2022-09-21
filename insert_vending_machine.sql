-- Insert values into tables
use vending_machine;

-------- Region --------
INSERT INTO `region` (`name`) VALUES ('Kyiv region');
INSERT INTO `region` (`name`) VALUES ('Lviv region');
INSERT INTO `region` (`name`) VALUES ('Lutsk region');
INSERT INTO `region` (`name`) VALUES ('Vinnytsia region');
INSERT INTO `region` (`name`) VALUES ('Odesa region');
INSERT INTO `region` (`name`) VALUES ('Luhansk region');
INSERT INTO `region` (`name`) VALUES ('Ivano-Frankivsk region');
INSERT INTO `region` (`name`) VALUES ('Kharkiv region');
INSERT INTO `region` (`name`) VALUES ('Dnipro region');
INSERT INTO `region` (`name`) VALUES ('Ternopil region');

-------- City --------
INSERT INTO `city` (`name`, `region_id`) VALUES ('Kyiv',1);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Lviv',2);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Lutsk',3);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Vinnytsia',4);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Odesa',5);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Luhansk',6);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Ivano-Frankivsk',7);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Kharkiv',8);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Dnipro',9);
INSERT INTO `city` (`name`, `region_id`) VALUES ('Ternopil',10);


-------- Address --------
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('1', 'Pavla Tychyny Ave', '1B', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('2', 'Kulparkivska St', '226A', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('3', 'Kyivska Square', '11', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('4', 'Keletska St', '121', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('5', 'Henuez`ka St', '5', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('6', 'Pasichna St', '164', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('7', 'Het`mana Mazepy St', '168', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('8', 'Akademika Pavlova St', '44Б', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('9', 'Andriia Fabra St', '7', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('10', 'Tekstyl`na St', '28Ч', null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('2', 'Yaneva St', null, null);
INSERT INTO `vending_machine`.`address` (`city_id`, `street`, `house_number`, `appartment_number`) VALUES ('2', 'Horodotska St', null, null);

-------- Service staff --------
INSERT INTO `vending_machine`.`service_staff` (`name`, `last_name`, `work_experience`, `is_available`, `address_id`) VALUES ('Danylo', 'Kovalchuk', '1 year', 1, '11');
INSERT INTO `vending_machine`.`service_staff` (`name`, `last_name`, `work_experience`, `is_available`, `address_id`) VALUES ('Jean Pierre', 'Polnareff', '7 months', 0, '12');
INSERT INTO `vending_machine`.`service_staff` (`name`, `last_name`, `work_experience`, `is_available`, `address_id`) VALUES ('Bohdan', 'Derunchyk', '9 months', 0, '11');
INSERT INTO `vending_machine`.`service_staff` (`name`, `last_name`, `work_experience`, `is_available`, `address_id`) VALUES ('Olha', 'Rubinchuk', '2 years', 1, '12');
INSERT INTO `vending_machine`.`service_staff` (`name`, `last_name`, `work_experience`, `is_available`, `address_id`) VALUES ('Maksym', 'Pasenko', '5 years', 1, '12');

-------- Machine model --------
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('GPE 25', 'GPE');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('GPE 30', 'GPE');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('Palma+ H70', 'Azkoyen');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('Mistral+ H70', 'Azkoyen');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('CVM-FD60DPC21.5', 'Qingdao Easy Touch Technology Co.');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('CVM-FD48WXT', 'Qingdao Easy Touch Technology Co.');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('AMS 39 Outdoor Snack and Drink Vending Machine', 'GLORY-VM');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('G-Snack Standard Twelve (XII) Master - SML', 'Vendo Sanden');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('G-Snack Design Six (VI) Master', 'Vendo Sanden');
INSERT INTO `vending_machine`.`machine_model` (`name`, `company`) VALUES ('CVM-FD48DPC7', 'Qingdao Easy Touch Technology Co.');

-------- Vending machine --------
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('GPE 25', "N49°50'38.5434'' E24°1'55.3938''", '1', '0635784668', '1', '0');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('GPE 30', "N49°50'38.5434'' E24°1'55.3938''", '2', '0635524668', '0', '0');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('Palma+ H70', "N49°50'38.5434'' E24°1'55.3938''", '3', '0655784668', '0', '1');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('Mistral+ H70', "N49°50'38.5434'' E24°1'55.3938''", '4', '0895784668', '0', '0');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('AMS 39 Outdoor Snack and Drink Vending Machine', "N49°50'38.5434'' E24°1'55.3938''", '5', '0635894668', '0', '1');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('CVM-FD60DPC21.5', "N49°50'38.5434'' E24°1'55.3938''", '6', '0623594668', '0', '0');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('G-Snack Standard Twelve (XII) Master - SML', "N49°50'38.5434'' E24°1'55.3938''", '7', '0632487668', '1', '1');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('CVM-FD48WXT', "N49°50'38.5434'' E24°1'55.3938''", '8', '0635111668', '0', '1');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('CVM-FD48WXT', "N49°50'38.5434'' E24°1'55.3938''", '9', '0635684668', '0', '0');
INSERT INTO `vending_machine` (`machine_model_name`, `gps`, `address_id`, `contact_number`, `is_out_of_order`, `is_empty`) VALUES ('GPE 25', "N49°50'38.5434'' E24°1'55.3938''", '10', '0634856968', '0', '0');


-------- Trademark --------
INSERT INTO `vending_machine`.`trademark` (`name`) VALUES ('Mondelez');
INSERT INTO `vending_machine`.`trademark` (`name`) VALUES ('Mars');
INSERT INTO `vending_machine`.`trademark` (`name`) VALUES ('Nestlé');
INSERT INTO `vending_machine`.`trademark` (`name`) VALUES ("McVitie's");
INSERT INTO `vending_machine`.`trademark` (`name`) VALUES ('Glico');

-------- Snack --------
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('Biscuit "Barni" Chocolate', '30', 'Mondelez');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('Biscuit "Barni" Milk', '30', 'Mondelez');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('OREO Original', '70', 'Mondelez');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('OREO Chocolate', '70', 'Mondelez');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('OREO Double Stuff', '70', 'Mondelez');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Original Fruity Candy Single Pack', '62', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Wild Berry Candy Single Pack', '62', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Brightside Candy Single Pack', '62', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Sour Candy Single Pack', '51', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Original Fruity Candy Share Size Bag', '133', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Wild Berry Candy Share Size Bag', '133', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Brightside Candy Share Size Bag', '133', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SKITTLES Sour Candy Share Size Bag', '105', 'Mars');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('CHOCOLATE Cream Covered Biscuit Stics', '70', 'Glico');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('STRAWBERRY Cream Covered Biscuit Stics', '70', 'Glico');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('COOKIES & CREAM Cream Covered Biscuit Stics', '70', 'Glico');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('Chocolate Hobnobs', '262', "McVitie's");
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SMARTIES Tube of Milk Chocolate', '28', 'Nestlé');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('SMARTIES Sharing Pouch of Milk Chocolate', '105', 'Nestlé');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('4 FINGER KITKAT', '42', 'Nestlé');
INSERT INTO `vending_machine`.`snack` (`name`, `net_weight`, `trademark_name`) VALUES ('Kit Kat Chunky Popcorn', '42', 'Nestlé');

-------- Menu --------
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '101', '7', '5', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '102', '7', '6', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '103', '8', '7', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '104', '8', '8', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '201', '9', '9', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '202', '9', '0', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '203', '9', '5', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '204', '9', '2', '15.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '301', '10', '4', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '302', '10', '8', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '303', '11', '7', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '304', '11', '9', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '401', '12', '2', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '402', '13', '0', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '403', '14', '5', '20');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('1', '404', '14', '0', '20');

INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '101', '1', '2', '10');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '102', '1', '5', '10');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '103', '3', '0', '10');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '201', '4', '4', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '202', '4', '1', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '203', '4', '8', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '301', '5', '5', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '302', '5', '9', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '303', '5', '2', '12');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '401', '6', '0', '15');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '402', '6', '1', '15');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('2', '403', '6', '0', '15');

INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '101', '21', '5', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '102', '21', '4', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '103', '21', '6', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '104', '21', '0', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '201', '22', '4', '17.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '202', '22', '1', '17.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '203', '22', '5', '17.5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('4', '204', '22', '2', '17.5');

INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '11', '15', '2', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '12', '15', '4', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '13', '15', '2', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '21', '16', '1', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '22', '16', '3', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '23', '16', '1', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '31', '17', '4', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '32', '17', '5', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '33', '17', '1', '24');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '41', '18', '5', '25');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '42', '18', '7', '25');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('6', '43', '18', '6', '25');

INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '11', '19', '0', '5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '12', '19', '0', '5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '13', '19', '0', '5');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '21', '20', '0', '9');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '22', '20', '0', '9');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '23', '20', '0', '9');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '31', '21', '0', '16');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '32', '21', '0', '16');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '33', '21', '0', '16');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '41', '22', '0', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '42', '22', '0', '17');
INSERT INTO `menu` (`vending_machine_id`, `slot_number`, `snack_id`, `quantity`, `price_per_unit`) VALUES ('7', '43', '22', '0', '17');




-------- Cash load --------
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('1', '1', '200', '2022-09-01');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('1', '2', '250', '2022-09-19');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('2', '3', '100', '2022-09-20');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('2', '5', '300', '2022-08-30');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('3', '1', '200', '2022-08-29');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('5', '4', '250', '2022-09-15');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('7', '4', '260', '2022-09-14');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('8', '3', '200', '2022-09-25');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('8', '3', '150', '2022-07-09');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('4', '2', '300', '2022-09-12');
INSERT INTO `cash_load` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('4', '5', '200', '2022-09-13');

-------- Cash withdrawal --------
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('1', '1', '500', '2022-09-01');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('1', '2', '650', '2022-09-19');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('2', '3', '800', '2022-09-20');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('2', '5', '400', '2022-08-30');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('3', '1', '500', '2022-08-29');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('5', '4', '350', '2022-09-15');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('7', '4', '260', '2022-09-14');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('8', '3', '400', '2022-09-25');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('8', '3', '250', '2022-07-09');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('4', '2', '700', '2022-09-12');
INSERT INTO `cash_withdrawal` (`vending_machine_id`, `service_staff_id`, `amount`, `date`) VALUES ('4', '5', '400', '2022-09-13');

-------------- Restock --------------
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '101', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '102', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '103', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '104', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '201', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '202', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '203', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '204', '12', '1', '2022-09-13');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '301', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '302', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '303', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '304', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '401', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '402', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '403', '12', '5', '2022-09-14');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('1', '404', '12', '5', '2022-09-14');

INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '11', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '12', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '13', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '21', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '22', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '23', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '31', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '32', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '33', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '41', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '42', '10', '4', '2022-09-17');
INSERT INTO `restock` (`menu_vending_machine_id`, `menu_slot_number`, `quantity`, `service_staff_id`, `date`) VALUES ('6', '43', '10', '4', '2022-09-17');

-------- Sold --------
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '101', '2022-09-20 01:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '102', '2022-09-20 10:10:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '204', '2022-09-20 10:15:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '202', '2022-09-20 10:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '301', '2022-09-20 10:30:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '104', '2022-09-20 10:40:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '401', '2022-09-20 10:55:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '404', '2022-09-20 11:00:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '402', '2022-09-20 11:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '103', '2022-09-20 11:32:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '103', '2022-09-20 12:50:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '102', '2022-09-20 12:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '401', '2022-09-20 12:59:30');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '403', '2022-09-20 14:10:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '101', '2022-09-20 14:11:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-20 15:24:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-20 16:56:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '203', '2022-09-20 16:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '102', '2022-09-20 18:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '104', '2022-09-20 18:42:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '103', '2022-09-20 18:49:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '202', '2022-09-20 18:50:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '201', '2022-09-20 18:55:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '101', '2022-09-20 18:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '104', '2022-09-20 20:16:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-20 20:34:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '401', '2022-09-20 20:39:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '403', '2022-09-20 20:46:00');

INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '101', '2022-09-21 01:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '102', '2022-09-21 10:10:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '204', '2022-09-21 10:15:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '202', '2022-09-21 10:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '301', '2022-09-21 10:30:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '104', '2022-09-21 10:40:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '401', '2022-09-21 10:55:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '404', '2022-09-21 11:00:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '402', '2022-09-21 11:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '103', '2022-09-21 11:32:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '103', '2022-09-21 12:50:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '102', '2022-09-21 12:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '401', '2022-09-21 12:59:30');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '403', '2022-09-21 14:10:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '101', '2022-09-21 14:11:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-21 15:24:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-21 16:56:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '203', '2022-09-21 16:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '102', '2022-09-21 18:20:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '104', '2022-09-21 18:42:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '103', '2022-09-21 18:49:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '202', '2022-09-21 18:50:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('4', '201', '2022-09-21 18:55:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '101', '2022-09-21 18:59:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '104', '2022-09-21 20:16:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('2', '201', '2022-09-21 20:34:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '401', '2022-09-21 20:39:00');
INSERT INTO `sold` (`menu_vending_machine_id`, `menu_slot_number`, `time`) VALUES ('1', '403', '2022-09-21 20:46:00');
