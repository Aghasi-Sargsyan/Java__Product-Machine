package com.aghas.first.managers;


import com.aghas.first.expetions.NullProductExeption;
import com.aghas.first.products.Product;
import com.aghas.first.products.drinkable.Coffee;
import com.aghas.first.products.drinkable.Tea;
import com.aghas.first.products.eatable.ChocolateBars;

import java.util.LinkedHashMap;
import java.util.Map;

final class ProductManager {

    private ProductManager() {

    }

    static ProductManager getsInstance() {
        if (sInstance == null) {
            sInstance = new ProductManager();
        }
        return sInstance;
    }

    boolean isProductID(String id) {
        for (String key : PRODUCT_HASH_MAP.keySet()) {
            if (key.equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static final LinkedHashMap<String, Product> PRODUCT_HASH_MAP = new LinkedHashMap<>();
    private static ProductManager sInstance;

    static {
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Coffee.ESPRESSO), Coffee.ESPRESSO);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Coffee.CAPPUCCINO), Coffee.CAPPUCCINO);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Coffee.LATTEMACCHIATO), Coffee.LATTEMACCHIATO);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Coffee.MOCACCINO), Coffee.MOCACCINO);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Tea.LEMONTEA), Tea.LEMONTEA);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(Tea.BERRYTEA), Tea.BERRYTEA);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(ChocolateBars.MARS), ChocolateBars.MARS);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(ChocolateBars.SNICKERS), ChocolateBars.SNICKERS);
        PRODUCT_HASH_MAP.put(SaleManager.productIDs(ChocolateBars.TWIX), ChocolateBars.TWIX);
    }

    Product findingProductFromHasMap(String input) throws NullProductExeption {

        if (PRODUCT_HASH_MAP.containsKey(input)) {
            return PRODUCT_HASH_MAP.get(input);
        }
        throw new NullProductExeption();
    }

    String[] productSelectionMenuTxt() {
        int maxLenght = 0;
        for (Product product : PRODUCT_HASH_MAP.values()) {
            if (product.getName().length() > maxLenght) {
                maxLenght = product.getName().length();
            }
        }

        StringBuilder sb = new StringBuilder();
        int lineLenght = 0;
        for (Map.Entry me : PRODUCT_HASH_MAP.entrySet()) {
            Product product = (Product) me.getValue();
            sb.append("-Product: ").append(product.getName());
            for (int i = 0; i < maxLenght - product.getName().length(); i++) {
                sb.append(" ");
            }
            sb.append("  Code: ").append(me.getKey()).append("  Price: ").append("(").append(product.getPrice()).append(" AMD)-").append(",");
            lineLenght = String.valueOf(sb).split(",")[0].length();
            for (int i = 0; i < lineLenght; i++) {
                sb.append("_");
            }
            sb.append(",");
        }
        for (int i = 0; i < lineLenght; i++) {
            sb.insert(0, "_");
        }
        sb.insert(lineLenght, ",");
        return String.valueOf(sb).split(",");
    }
}