package org.example.Classes;

public class RequestThree {

    int id_bus;
    int id_route;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int tail_number;
    String brand, state_number;

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public int getId_route() {
        return id_route;
    }

    public void setId_route(int id_route) {
        this.id_route = id_route;
    }

    public int getTail_number() {
        return tail_number;
    }

    public void setTail_number(int tail_number) {
        this.tail_number = tail_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }
}
