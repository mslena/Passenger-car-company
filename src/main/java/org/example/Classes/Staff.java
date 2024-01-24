package org.example.Classes;

import java.util.Date;

public class Staff {
    int id_staff;
    Date date_of_birth;
    String full_name, address, passport_details, phone_number, work_book_number;

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport_details() {
        return passport_details;
    }

    public void setPassport_details(String passport_details) {
        this.passport_details = passport_details;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getWork_book_number() {
        return work_book_number;
    }

    public void setWork_book_number(String work_book_number) {
        this.work_book_number = work_book_number;
    }
}
