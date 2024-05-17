package com.sweetbox;

public class Main {
    public static void main(String[] args) {
        SweetBox box = new SweetBox();
        box.addSweet(new Chocolate("Dark Chocolate", 100, 5.0, "70%"));
        box.addSweet(new Candy("Gummy Bear", 50, 2.0, "Fruit"));
        box.addSweet(new Cookie("Oreo", 30, 1.0, "Round"));

        System.out.println("All sweets info:");
        System.out.println(box.getAllSweetsInfo());

        System.out.println("Total weight: " + box.getTotalWeight());
        System.out.println("Total price: " + box.getTotalPrice());

        box.optimizeByWeight(120);
        System.out.println("\nAfter optimization by weight (max 120g):");
        System.out.println(box.getAllSweetsInfo());

        box.optimizeByPrice(50);
        System.out.println("\nAfter optimization by price (max 50g):");
        System.out.println(box.getAllSweetsInfo());
    }
}