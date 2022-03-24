package com.zxxia.s55_factorypattern;

public abstract class Computer {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    double prize;

    protected abstract void start();
}
