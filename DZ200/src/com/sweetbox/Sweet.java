package com.sweetbox;

abstract class Sweet {
    protected String name;
    protected int weight; // в граммах
    protected double price; // в долларах
    protected String uniqueParameter;

    public Sweet(String name, int weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public String getInfo() {
        return "Name: " + name + ", Weight: " + weight + "g, Price: $" + price + ", Unique: " + uniqueParameter;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}