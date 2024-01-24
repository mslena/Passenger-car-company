package org.example.Classes;

public class Bus {
    private int id_bus;
    private int tail_number;

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public int getTail_number() {
        return tail_number;
    }

    public void setTail_number(int tail_number) {
        this.tail_number = tail_number;
    }

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String state_number;
    private String brand;
}
