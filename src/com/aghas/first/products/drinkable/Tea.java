package com.aghas.first.products.drinkable;

import com.aghas.first.products.Ingredients.TeaIngredients;
import com.aghas.first.products.Product;

public enum Tea implements Product, TeaIngredients {
    LEMONTEA("Lemon Tea", 200, 100, 20, 0), BERRYTEA("Berry Tea", 200, 100, 0, 20);

    private String name;
    private int price;

    private int waterAmount;
    private int lemonTeaAmount;
    private int berryTeaAmount;

    Tea(String name, int price, int waterAmount, int lemonTeaAmount, int berryTeaAmount) {
        this.name = name;
        this.price = price;
        this.waterAmount = waterAmount;
        this.lemonTeaAmount = lemonTeaAmount;
        this.berryTeaAmount = berryTeaAmount;
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
    public int getWaterAmount() {
        return waterAmount;
    }

    @Override
    public int getLemonTeaAmount() {
        return lemonTeaAmount;
    }

    @Override
    public int getBerryTeaAmount() {
        return berryTeaAmount;
    }

    @Override
    public String appearance() {
        return " ;,'\n" +
                "     _o_    ;:;'\n" +
                " ,-.'---`.__ ;\n" +
                "((j`=====',-'\n" +
                " `-\\     /\n" +
                "    `-=-'   ";
    }
}
