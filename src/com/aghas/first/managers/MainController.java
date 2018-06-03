package com.aghas.first.managers;


import com.aghas.first.expetions.NullProductExeption;
import com.aghas.first.products.Product;

import java.util.Scanner;

public final class MainController {

    private MainController() {

    }

    private static MainController sInstance;

    public static MainController getsInstance() {
        if (sInstance == null) {
            sInstance = new MainController();
        }
        return sInstance;
    }

    private CoinManager cm = CoinManager.getsInstance();
    private ProductManager pm = ProductManager.getsInstance();
    private Stock stock = new Stock();
    private CoffeeMaker coffeeMaker = CoffeeMaker.getsInstance();

//    private static int totalMoney;
//    private static Product product;

//    static int getTotalMoney() {
//        return totalMoney;
//    }
//
//    static Product getProduct() {
//        return product;
//    }

    public void start() {
        while (true) {
            boolean isProductReady = false;
            Product product;
            int totalMoney = 0;
            DisplayManager.starTxt(greetingTxt());
            DisplayManager.pureTxt(pm.productSelectionMenuTxt());
            DisplayManager.consoleStyleTxt("please insert coin or choose product", "you can always ABORT the operation by pressing \"ex\" ");

            do {
                String input = readInput();
                if (cm.isCoin(input)) {
                    int coin = Integer.parseInt(input);
                    if (cm.isCoinValid(coin)) {
                        cm.addCoinToStock(coin);
                        totalMoney += coin;
                        DisplayManager.consoleStyleTxt(BalanceInformer(totalMoney));
                    } else {                                                                                                        //input is a coin (can parse to int) but isn't valid
                        DisplayManager.errorTxt("wrong type of money", "please enter valid coin: " + cm.validCoinsTxt());
                    }
                } else {                                                                                                            //input is not a coin (can't parse to int)
                    if (pm.isProductID(input)) {
                        try {
                            product = pm.findingProductFromHasMap(input);
                            if (isMoneyEnoughForProduct(totalMoney,product)) {
                                if (stock.isIngredientsEnoughForProduct(product)) {
                                    Thread coffeeMakerTread = new Thread(coffeeMaker.new MakeProductRunnable(product));
                                    coffeeMakerTread.start();
                                    Thread cmTread = new Thread(cm.new ChangeBackRunnable(totalMoney, product));
                                    cmTread.start();
                                    try {
                                        cmTread.join();
                                        coffeeMakerTread.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    totalMoney = 0;
                                    isProductReady = true;
                                } else {
                                    DisplayManager.consoleStyleTxt("not enough ingredients");
                                }
                            } else {                                                                                                //if money is not enough for product
                                DisplayManager.errorTxt("not enough money please add more");
                                DisplayManager.consoleStyleTxt(BalanceInformer(totalMoney));
                            }
                        } catch (NullProductExeption e) {
                            e.printStackTrace();
                        }
                    } else {                                                                                                        //input is not a product id
                        if (abortOperation(input)) {
                            DisplayManager.consoleStyleTxt("ABORTED successfully");
                            cm.AbortedChangeBack(totalMoney);
                            totalMoney = 0;
                            isProductReady = true;
                        } else {
                            DisplayManager.errorTxt("wrong product code");
                        }
                    }
                }
            } while (!isProductReady);
        }
    }

    private boolean abortOperation(String input) {
        return input.equals("ex");
    }



    private String[] greetingTxt() {
        return new String[]{"You are greeted by a food machine", "Here is our menu: "};
    }

    private String BalanceInformer(int totalMoney) {
        return "your current balance is " + totalMoney + " AMD";
    }

    private String readInput() {
        Scanner s = new Scanner(System.in);
        return s.next();
    }

    private boolean isMoneyEnoughForProduct(int totalMoney, Product product) {
        return totalMoney - product.getPrice() >= 0;
    }
}