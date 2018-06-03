package com.aghas.first.expetions;

public class NullProductExeption extends Exception {

    public NullProductExeption() {
        super("product doesn't exist");
    }
}
