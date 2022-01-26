package com.zxxia.s10_codeblock;

import java.util.ArrayList;

public class CardInit {
    static ArrayList<String> cardList = new ArrayList<>();

    static {
        String[] color = {"黑桃", "红心", "方块", "梅花"};
        String[] value = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < color.length; j++) {
                cardList.add(String.format("%s%s", color[j], value[i]));
            }
        }
        cardList.add("小王");
        cardList.add("大王");
    }

    private void print() {
        System.out.println(cardList.toString());
    }

    public static void main(String[] args) {
        CardInit c = new CardInit();
        c.print();
    }
}
