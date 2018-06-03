package com.aghas.first.products.drinkable;

import com.aghas.first.products.Ingredients.CoffeeIngredients;
import com.aghas.first.products.Product;

import java.util.HashMap;

public enum Coffee implements Product, CoffeeIngredients {
    ESPRESSO("Espresso", 200, 10, 35, 0, 0, 0), CAPPUCCINO("Cappuccino", 300, 50, 0, 100, 0, 0), LATTEMACCHIATO("Latte Macchiato", 300, 35, 0, 100, 0, 0),

    MOCACCINO("Mocaccino", 500, 30, 0, 150, 20, 10);

    private String name;
    private int price;

    private int COFFEE_AMOUNT;
    private int WATER_AMOUNT;
    private int MILK_AMOUNT;
    private int CHOCOLATE_AMOUNT;
    private int CREAM_AMOUNT;

    Coffee(String name, int price, int COFFEE_AMOUNT, int WATER_AMOUNT, int MILK_AMOUNT, int CHOCOLATE_AMOUNT, int CREAM_AMOUNT) {
        this.name = name;
        this.price = price;
        this.WATER_AMOUNT = WATER_AMOUNT;
        this.COFFEE_AMOUNT = COFFEE_AMOUNT;
        this.MILK_AMOUNT = MILK_AMOUNT;
        this.CHOCOLATE_AMOUNT = CHOCOLATE_AMOUNT;
        this.CREAM_AMOUNT = CREAM_AMOUNT;
    }


    @Override
    public String appearance() {
        return "         {\n" +
                "      {   }\n" +
                "       }_{ __{\n" +
                "    .-{   }   }-.\n" +
                "   (   }     {   )\n" +
                "   |`-.._____..-'|\n" +
                "   |             ;--.\n" +
                "   |            (__  \\\n" +
                "   |             | )  )\n" +
                "   |             |/  /\n" +
                "   |             /  /    \n" +
                "   |            (  /\n" +
                "   \\             y'\n" +
                "    `-.._____..-'";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getCoffeeAmount() {
        return COFFEE_AMOUNT;
    }

    @Override
    public int getWaterAmount() {
        return WATER_AMOUNT;
    }

    @Override
    public int getMilkAmount() {
        return MILK_AMOUNT;
    }

    @Override
    public int getChocolateAmount() {
        return CHOCOLATE_AMOUNT;
    }

    @Override
    public int getCreamAmount() {
        return CREAM_AMOUNT;
    }
}
