package org.example.Classes;

import java.util.Date;

public class RequestTwo {
    int id_route, tail_number;
    String brand, state_number;

    Date date_g;

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

    public Date getDate_g() {
        return date_g;
    }

    public void setDate_g(Date date_g) {
        this.date_g = date_g;
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
