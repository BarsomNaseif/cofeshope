

package com.mycompany.mavenproject3;

import java.util.ArrayList;
import java.util.List;

class Menu {
    String name;
    String type;
    double price;

    Menu(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}

class CoffeeShop {
    String name;
    List<Menu> menu;
    List<String> orders;

    CoffeeShop(String name, List<Menu> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<>();
    }

    String addOrder(String itemName) {
        for (Menu item : menu) {
            if (item.name.equals(itemName)) {
                orders.add(itemName);
                return "Order added: " + itemName;
            }
        }
        return "This item is currently unavailable!";
    }

    String fulfillOrder() {
        if (!orders.isEmpty()) {
            String item = orders.remove(0);
            return "The " + item + " is ready!";
        }
        return "All orders have been fulfilled!";
    }

    List<String> listOrders() {
        return orders;
    }

    double dueAmount() {
        double totalAmount = 0.0;
        for (String item : orders) {
            for (Menu menu : menu) {
                if (menu.name.equals(item)) {
                    totalAmount += menu.price;
                    break;
                }
            }
        }
        return totalAmount;
    }

    String cheapestItem() {
        if (menu.isEmpty()) {
            return "No items on the menu!";
        }
        Menu cheapest = menu.get(0);
        for (Menu item : menu) {
            if (item.price < cheapest.price) {
                cheapest = item;
            }
        }
        return cheapest.name;
    }

    List<String> drinksOnly() {
        List<String> drinks = new ArrayList<>();
        for (Menu item : menu) {
            if (item.type.equals("drink")) {
                drinks.add(item.name);
            }
        }
        return drinks;
    }

    List<String> foodOnly() {
        List<String> food = new ArrayList<>();
        for (Menu item : menu) {
            if (item.type.equals("food")) {
                food.add(item.name);
            }
        }
        return food;
    }
}

public class Mavenproject3 {
    public static void main(String[] args) {
   
        Menu item1 = new Menu("Cappuccino", "drink", 3.99);
        Menu item2 = new Menu("Croissant", "food", 2.49);
        Menu item3 = new Menu("Latte", "drink", 4.49);
        Menu item4 = new Menu("Muffin", "food", 1.99);

        
        List<Menu> menu = new ArrayList<>();
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        CoffeeShop coffeeShop = new CoffeeShop("My Coffee Shop", menu);

   
        System.out.println(coffeeShop.addOrder("Cappuccino"));
        System.out.println(coffeeShop.addOrder("Latte"));
        System.out.println(coffeeShop.addOrder("Espresso")); 

     
        System.out.println(coffeeShop.fulfillOrder());
        System.out.println(coffeeShop.fulfillOrder());
        System.out.println(coffeeShop.fulfillOrder()); 

     
        System.out.println("Orders: " + coffeeShop.listOrders());

      
        System.out.println("Due amount: $" + coffeeShop.dueAmount());

        
        System.out.println("Cheapest item: " + coffeeShop.cheapestItem());

        
        System.out.println("Drinks only: " + coffeeShop.drinksOnly());

       
        System.out.println("Food only: " + coffeeShop.foodOnly());
    }
}


