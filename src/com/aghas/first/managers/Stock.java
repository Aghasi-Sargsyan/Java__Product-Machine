package com.aghas.first.managers;


import com.aghas.first.expetions.NullProductExeption;
import com.aghas.first.products.Ingredients.CoffeeIngredients;
import com.aghas.first.products.Ingredients.TeaIngredients;
import com.aghas.first.products.Product;
import com.aghas.first.products.drinkable.Coffee;
import com.aghas.first.products.drinkable.Tea;
import com.aghas.first.products.eatable.ChocolateBars;

import java.util.HashMap;
import java.util.Map;


public final class Stock implements CoffeeIngredients, TeaIngredients {

    private int coffeeAmount;
    private int waterAmount;
    private int milkAmount;
    private int chocolateAmount;
    private int creamAmount;
    private int lemonTeaAmount;
    private int berryTeaAmount;

    private static HashMap<Enum, Integer> eatableAmountMap = new HashMap<>();

    static {
        eatableAmountMap.put(ChocolateBars.MARS, 1);
        eatableAmountMap.put(ChocolateBars.SNICKERS, 0);
        eatableAmountMap.put(ChocolateBars.TWIX, 0);
    }

    Stock() {
        this.coffeeAmount = 200;
        this.waterAmount = 200;
        this.milkAmount = 200;
        this.chocolateAmount = 100;
        this.creamAmount = 100;
        this.lemonTeaAmount = 100;
        this.berryTeaAmount = 100;
    }


    boolean isIngredientsEnoughForProduct(Product product) throws NullProductExeption {
        if (product instanceof Coffee) {
            Coffee coffee = (Coffee) product;
            return waterAmount - coffee.getWaterAmount() >= 0 &&
                    milkAmount - coffee.getMilkAmount() >= 0 &&
                    chocolateAmount - coffee.getChocolateAmount() >= 0 &&
                    coffeeAmount - coffee.getCoffeeAmount() >= 0 &&
                    creamAmount - coffee.getCreamAmount() >= 0;
        } else {
            if (product instanceof Tea) {
                Tea tea = (Tea) product;
                return waterAmount - tea.getWaterAmount() >= 0 &&
                        berryTeaAmount - tea.getBerryTeaAmount() >= 0 &&
                        lemonTeaAmount - tea.getLemonTeaAmount() >= 0;
            } else {
                if (product instanceof ChocolateBars) {
                    for (Map.Entry<Enum, Integer> entry : eatableAmountMap.entrySet()) {
                        if (entry.getKey().equals(product)) {
                            return entry.getValue() > 0;
                        }
                    }
                }
            }
        }
        throw new

                NullProductExeption();
    }

    @Override
    public int getWaterAmount() {
        return waterAmount;
    }

    @Override
    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    @Override
    public int getMilkAmount() {
        return milkAmount;
    }

    @Override
    public int getChocolateAmount() {
        return chocolateAmount;
    }

    @Override
    public int getCreamAmount() {
        return creamAmount;
    }

    @Override
    public int getLemonTeaAmount() {
        return lemonTeaAmount;
    }

    @Override
    public int getBerryTeaAmount() {
        return berryTeaAmount;
    }
}
