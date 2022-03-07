package com.zxxia.s36_ddz;

import com.zxxia.iTest;

import java.util.*;

/**
 * 案例：斗地主
 * 启动游戏房间之后，应提前准备好54张牌，完成洗牌、发牌、牌排序逻辑
 */

class Card {
    String size;
    String color;
    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Card() {
    }

    public Card(String size, String color, int index) {
        this.size = size;
        this.color = color;
        this.index = index;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + size;
    }
}

class Player {
    String name;
    List<Card> cards;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}

class Game implements iTest {
    static List<Card> allCards = new ArrayList<>();

    static {
        String[] sizes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        int index = 0;
        for (String size : sizes) {
            index++;
            for (String color : colors) {
                allCards.add(new Card(size, color, index));

            }
        }

        //插入大小王
        Card card1 = new Card("", "Joker1", ++index);
        Card card2 = new Card("", "Joker2", ++index);
        Collections.addAll(allCards, card1, card2);
    }

    static int CARD_COUNT = 54;
    static int PLAYER_COUNT = 3;
    static int DEFAULT_COUNT = 17;
    ArrayList<Integer> cards = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    @Override
    public void run() {
        System.out.println("初始化牌：" + allCards);
        Collections.shuffle(allCards);
        System.out.println("洗牌：" + allCards);

        System.out.println("发牌");
        String[] names = {"张三", "李四", "王五"};
        for (int i = 0; i < PLAYER_COUNT; i++) {
            List<Card> cards = allCards.subList(i * DEFAULT_COUNT, i * DEFAULT_COUNT + DEFAULT_COUNT);
            Player p1 = new Player(names[i], cards);
            players.add(p1);
        }
        List<Card> lastCard = allCards.subList(DEFAULT_COUNT * PLAYER_COUNT, CARD_COUNT);
        System.out.println("最后三张牌：" + lastCard);

        System.out.println("玩家牌：" + players);

        System.out.println("排序");
        for (int i = 0; i < PLAYER_COUNT; i++) {
            players.get(i).getCards().sort(new Comparator<Card>() {

                @Override
                public int compare(Card o1, Card o2) {
                    return o2.getIndex() - o1.getIndex();
                }
            });
        }
        System.out.println("玩家排序牌：" + players);

    }


}


public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
