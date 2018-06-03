package com.aghas.first.managers;


import com.aghas.first.products.drinkable.Coffee;
import com.aghas.first.products.drinkable.Tea;
import com.aghas.first.products.eatable.ChocolateBars;

public final class SaleManager {

    private static SaleManager sInstance;

    private SaleManager() {

    }

    public static SaleManager getsInstance() {
        if (sInstance == null) {
            sInstance = new SaleManager();
        }
        return sInstance;
    }

    static String productIDs(Saleable product) {
        String idLetter;
        if (product instanceof Coffee) {
            idLetter = "c";
            return idLetter + ((Coffee) product).ordinal();
        } else {
            if (product instanceof ChocolateBars) {
                idLetter = "s";
                return idLetter + ((ChocolateBars) product).ordinal();
            }else{
                if (product instanceof Tea) {
                    idLetter = "t";
                    return idLetter + ((Tea) product).ordinal();
                }
            }
        }
        throw new RuntimeException("This product is not an instance");
    }

    public interface Saleable {
        int getPrice();
    }
}
