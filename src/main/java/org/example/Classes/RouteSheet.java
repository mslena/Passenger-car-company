package org.example.Classes;

import java.util.Date;

public class RouteSheet {
    int id_route_sheet, id_route, id_bus;
    Date date;

    public int getId_route_sheet() {
        return id_route_sheet;
    }

    public void setId_route_sheet(int id_route_sheet) {
        this.id_route_sheet = id_route_sheet;
    }

    public int getId_route() {
        return id_route;
    }

    public void setId_route(int id_route) {
        this.id_route = id_route;
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
