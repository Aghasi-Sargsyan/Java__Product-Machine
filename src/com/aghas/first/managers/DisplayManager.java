package com.aghas.first.managers;

final class DisplayManager {

    private DisplayManager() {

    }

    static void consoleStyleTxt(String... line) {
        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            sb.append("-- ").append(s).append("\n");
        }
        System.out.println(sb);
    }

    static void pureTxt(String... line) {
        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            sb.append("\n").append(s);
        }
        System.out.println(sb);
    }

    static void ForLoadingAndChangeBack(String ... line) {
        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    static void starTxt(String... strings) {
        StringBuilder sb = new StringBuilder();
        int maxLenght = strings[0].length();
        for (String string : strings) {
            if (string.length() > maxLenght) {
                maxLenght = string.length();
            }
        }
        for (int i = 0; i <= maxLenght + 3; i++) {
            sb.append("*");
        }
        for (String s : strings) {
            sb.append("\n").append("* ").append(s);
            for (int i = 0; i < maxLenght - s.length() + 1; i++) {
                sb.append(" ");
            }
            sb.append("*");
        }
        sb.append("\n");
        for (int i = 0; i <= maxLenght + 3; i++) {
            sb.append("*");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    static void errorTxt(String... line) {
        StringBuilder sb = new StringBuilder();
        for (String s : line) {
            sb.append("!!!").append(s).append("!!!").append("\n");
        }
        System.out.println(sb);
    }
}
