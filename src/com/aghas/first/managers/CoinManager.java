package com.aghas.first.managers;

import com.aghas.first.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

final class CoinManager {

    private CoinManager() {

    }

    private static CoinManager sInstance;

    static CoinManager getsInstance() {
        if (sInstance == null) {
            sInstance = new CoinManager();
        }
        return sInstance;
    }

    private static Map<Integer, Integer> coinsStockArray = new TreeMap<>(Collections.reverseOrder());

    static {
        coinsStockArray.put(1000, 0);
        coinsStockArray.put(500, 0);
        coinsStockArray.put(200, 0);
        coinsStockArray.put(100, 0);
        coinsStockArray.put(50, 0);
    }

    boolean isCoin(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isCoinValid(int coin) {
        for (int elem : coinsStockArray.keySet()) {
            if (elem == coin) {
                return true;
            }
        }
        return false;
    }

    void addCoinToStock(int coin) {
        coinsStockArray.put(coin, coinsStockArray.get(coin) + 1);
    }

    private void changeBack(int totalMoney, Product product) {
        int totalChangeBack = totalMoney - product.getPrice();
        int changeBackTemp = totalChangeBack;
        ArrayList<Integer> changeBackArray = new ArrayList<>();
        while (changeBackTemp != 0) {
            for (Integer coin : coinsStockArray.keySet()) {
                if (coin > 500) {
                    continue;
                }
                while (coinsStockArray.get(coin) > 0 && changeBackTemp != 0 && coin <= changeBackTemp) {
                    if (changeBackTemp - coin >= 0) {
                        changeBackArray.add(coin);
                        changeBackTemp -= coin;
                        coinsStockArray.put(coin, coinsStockArray.get(coin) - 1);
                    }
                }
            }
            if (changeBackTemp > 0) {
                break;
            }
        }
        if (!changeBackArray.isEmpty()) {
            DisplayManager.consoleStyleTxt("your change is " + totalChangeBack + " AMD please take it: ");
            for (int coin : changeBackArray) {
                DisplayManager.ForLoadingAndChangeBack(Integer.toString(coin));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (changeBackTemp > 0) {
            DisplayManager.errorTxt("sorry we cant return " + changeBackTemp + " (AMD)", "coin stock is empty");
        }
    }

    void AbortedChangeBack(int totalMoney) {
        int changeBackTemp = totalMoney;
        ArrayList<Integer> changeBackArray = new ArrayList<>();
        while (changeBackTemp != 0) {
            for (Integer coin : coinsStockArray.keySet()) {
                if (coin > 500) {
                    continue;
                }
                while (coinsStockArray.get(coin) > 0 && changeBackTemp != 0) {
                    if (changeBackTemp - coin >= 0) {
                        changeBackArray.add(coin);
                        changeBackTemp -= coin;
                        coinsStockArray.put(coin, coinsStockArray.get(coin) - 1);
                    }
                }
            }
            if (changeBackTemp > 0) {
                break;
            }
        }
        if (!changeBackArray.isEmpty()) {
            DisplayManager.consoleStyleTxt("your change is " + totalMoney + " AMD please take it: ");
            for (int coin : changeBackArray) {
                DisplayManager.pureTxt(Integer.toString(coin));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (changeBackTemp > 0) {
            DisplayManager.errorTxt("sorry we cant return " + changeBackTemp + " (AMD)", "coin stock is empty");
        }
    }

    String validCoinsTxt() {
        StringBuilder sb = new StringBuilder();
        for (int num : coinsStockArray.keySet()) {
            sb.append("-").append(num).append("- ");
        }
        return String.valueOf(sb);
    }

    class ChangeBackRunnable implements Runnable {

        int totalMoney;
        Product product;

        ChangeBackRunnable(int totalMoney, Product product) {
            this.totalMoney = totalMoney;
            this.product = product;
        }

        @Override
        public void run() {
            changeBack(totalMoney, product);
        }
    }
}
