package com.sweetbox;

import java.util.ArrayList;
import java.util.List;

class SweetBox implements SweetBoxInterface {
    private List<Sweet> sweets;

    public SweetBox() {
        this.sweets = new ArrayList<>();
    }

    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void removeSweet(int index) {
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index);
        }
    }

    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        }
    }

    @Override
    public int getTotalWeight() {
        return sweets.stream().mapToInt(Sweet::getWeight).sum();
    }

    @Override
    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    @Override
    public String getAllSweetsInfo() {
        StringBuilder info = new StringBuilder();
        for (Sweet sweet : sweets) {
            info.append(sweet.getInfo()).append("\n");
        }
        return info.toString();
    }

    @Override
    public void optimizeByWeight(int maxWeight) {
        while (getTotalWeight() > maxWeight) {
            int minWeightIndex = 0;
            for (int i = 1; i < sweets.size(); i++) {
                if (sweets.get(i).getWeight() < sweets.get(minWeightIndex).getWeight()) {
                    minWeightIndex = i;
                }
            }
            removeSweet(minWeightIndex);
        }
    }

    @Override
    public void optimizeByPrice(int maxWeight) {
        while (getTotalWeight() > maxWeight) {
            int minPriceIndex = 0;
            for (int i = 1; i < sweets.size(); i++) {
                if (sweets.get(i).getPrice() < sweets.get(minPriceIndex).getPrice()) {
                    minPriceIndex = i;
                }
            }
            removeSweet(minPriceIndex);
        }
    }
}

interface SweetBoxInterface {
    void addSweet(Sweet sweet);
    void removeSweet(int index);
    void removeLastSweet();
    int getTotalWeight();
    double getTotalPrice();
    String getAllSweetsInfo();
    void optimizeByWeight(int maxWeight);
    void optimizeByPrice(int maxWeight);
}