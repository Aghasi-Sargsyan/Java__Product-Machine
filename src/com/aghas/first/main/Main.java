package com.aghas.first.main;


import com.aghas.first.managers.MainController;

public class Main {

    public static void main(String[] args) {
        MainController m = MainController.getsInstance();
        m.start();
    }
}
