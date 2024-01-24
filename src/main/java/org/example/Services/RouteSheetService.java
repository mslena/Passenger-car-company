package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.RouteSheetDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteSheetService {

    private final RouteSheetDAO routeSheetDAO;

    public List getAll() {
        return routeSheetDAO.getAll();
    }

    public  void setAll(String id_route, String id_bus, String date) {
        routeSheetDAO.setAll(Integer.parseInt(id_route), Integer.parseInt(id_bus), date);
    }

    public void update(String id_route_sheet,String id_route, String id_bus, String date) {
        if(!id_route.isEmpty()){
            routeSheetDAO.updateIdRoute(Integer.parseInt(id_route_sheet), Integer.parseInt(id_route));
        }
        if(!id_bus.isEmpty()) {
            routeSheetDAO.updateIdBus(Integer.parseInt(id_route_sheet), Integer.parseInt(id_bus));
        }
        if(!date.isEmpty()) {
            routeSheetDAO.updateDate(Integer.parseInt(id_route_sheet), date);
        }
    }

    public void delete(String id_route_sheet) {
        routeSheetDAO.delete(Integer.parseInt(id_route_sheet));
    }
}
