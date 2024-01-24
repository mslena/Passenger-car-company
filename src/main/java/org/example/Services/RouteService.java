package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.RouteDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {

    private final RouteDAO routeDAO;

    public List getAll() {
        return routeDAO.getAll();
    }

    public void setAll(String start_route, String end_route, String dispatch_time, String arrival_time) {
        routeDAO.setAll(start_route, end_route, dispatch_time, arrival_time);
    }

    public void update(String id_route, String start_route, String end_route, String dispatch_time, String arrival_time) {
        if(!start_route.isEmpty()) {
            routeDAO.updateStartRoute(Integer.parseInt(id_route), start_route);
        }
        if(!end_route.isEmpty()){
            routeDAO.updateEndRoute(Integer.parseInt(id_route), end_route);
        }
        if(!dispatch_time.isEmpty()) {
            routeDAO.updateDispatchTime(Integer.parseInt(id_route), dispatch_time);
        }
        if(!arrival_time.isEmpty()){
            routeDAO.updateArrivalTime(Integer.parseInt(id_route), arrival_time);
        }
    }

    public void delete(String id_route) {
        routeDAO.delete(Integer.parseInt(id_route));
    }
}
