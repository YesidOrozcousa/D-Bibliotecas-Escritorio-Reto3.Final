package com.usa.project.model.custom;

public class CapacityAmount {

    private int capacity;
    private int amount;

    public CapacityAmount(int capacity, int amount){
        this.capacity = capacity;
        this.amount=amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
