package org.example.Classes;

public class Route {
    int id_route;
    String start_route, end_route, dispatch_time, arrival_time;

    public int getId_route() {
        return id_route;
    }

    public void setId_route(int id_route) {
        this.id_route = id_route;
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

    public String getDispatch_time() {
        return dispatch_time;
    }

    public void setDispatch_time(String dispatch_time) {
        this.dispatch_time = dispatch_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
}
