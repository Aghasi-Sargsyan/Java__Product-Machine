package com.aghas.first.managers;

import com.aghas.first.products.Product;

final class CoffeeMaker {

    private static CoffeeMaker sInstance;

    private CoffeeMaker() {

    }

    static CoffeeMaker getsInstance() {
        if (sInstance == null) {
            sInstance = new CoffeeMaker();
        }
        return sInstance;
    }

    void makeProduct(Product product) {
        DisplayManager.consoleStyleTxt("Preparing.....");
        for (int i = 0; i < 12; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            DisplayManager.ForLoadingAndChangeBack(".");
        }
        System.out.println();
        String takeProduct = "your product is ready, please take your " + product.getName();
        DisplayManager.consoleStyleTxt(takeProduct);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DisplayManager.pureTxt(product.appearance());
    }

    class MakeProductRunnable implements Runnable {

        Product product;

        MakeProductRunnable(Product product) {
            this.product = product;
        }
        @Override
        public void run() {
            makeProduct(product);
        }
    }
}
