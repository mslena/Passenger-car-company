package org.example.Classes;

import java.util.Date;

public class Waybill {
    int  tail_number, id_interchange;
    String brand,  state_number, start_route, end_route,  full_name_driver, phone_number_driver, full_name_conductor, phone_number_conductor, arrival_time, dispath_time;

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDispath_time() {
        return dispath_time;
    }

    public void setDispath_time(String dispath_time) {
        this.dispath_time = dispath_time;
    }

    public int getTail_number() {
        return tail_number;
    }

    public void setTail_number(int tail_number) {
        this.tail_number = tail_number;
    }

    public int getId_interchange() {
        return id_interchange;
    }

    public void setId_interchange(int id_interchange) {
        this.id_interchange = id_interchange;
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

    public String getStart_route() {
        return start_route;
    }

    public void setStart_route(String start_route) {
        this.start_route = start_route;
    }

    public String getEnd_route() {
        return end_route;
    }

    public void setEnd_route(String end_route) {
        this.end_route = end_route;
    }

    public String getFull_name_driver() {
        return full_name_driver;
    }

    public void setFull_name_driver(String full_name_driver) {
        this.full_name_driver = full_name_driver;
    }

    public String getPhone_number_driver() {
        return phone_number_driver;
    }

    public void setPhone_number_driver(String phone_number_driver) {
        this.phone_number_driver = phone_number_driver;
    }

    public String getFull_name_conductor() {
        return full_name_conductor;
    }

    public void setFull_name_conductor(String full_name_conductor) {
        this.full_name_conductor = full_name_conductor;
    }

    public String getPhone_number_conductor() {
        return phone_number_conductor;
    }

    public void setPhone_number_conductor(String phone_number_conductor) {
        this.phone_number_conductor = phone_number_conductor;
    }

    public Date getDate_g() {
        return date_g;
    }

    public void setDate_g(Date date_g) {
        this.date_g = date_g;
    }



    Date date_g;
}
