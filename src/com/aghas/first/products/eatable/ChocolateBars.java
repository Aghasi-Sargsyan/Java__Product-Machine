package com.aghas.first.products.eatable;


public enum ChocolateBars implements Eatable {
    MARS("Mars", 250), SNICKERS("Snickers", 250), TWIX("Twix", 250);

    private String name;
    private int price;

    ChocolateBars(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String appearance() {
        return "  ___  ___  ___  ___  ___.---------------.\n" +
                ".'\\__\\'\\__\\'\\__\\'\\__\\'\\__,`   .  ____ ___ \\\n" +
                "|\\/ __\\/ __\\/ __\\/ __\\/ _:\\   |`.  \\  \\___ \\\n" +
                " \\\\'\\__\\'\\__\\'\\__\\'\\__\\'\\_`.__|\"\"`. \\  \\___ \\\n" +
                "  \\\\/ __\\/ __\\/ __\\/ __\\/ __:                \\\n" +
                "   \\\\'\\__\\'\\__\\'\\__\\ \\__\\'\\_;-----------------`\n" +
                "    \\\\/   \\/   \\/   \\/   \\/ :                 |\n" +
                "     \\|______________________;________________|";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
