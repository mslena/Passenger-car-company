package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.InterchangeDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InterchangeService {

    private final InterchangeDAO interchangeDAO;

    public List getAll() {
        return interchangeDAO.getAll();
    }

    public void setAll(String id_driver, String id_conductor, String id_route_sheet) {
        interchangeDAO.setAll(Integer.parseInt(id_driver), Integer.parseInt(id_conductor), Integer.parseInt(id_route_sheet));
    }

    public void updateAll(String id_interchange, String id_driver, String id_conductor, String id_route_sheet) {
       if(!id_driver.isEmpty() ){
           interchangeDAO.updateDriver(Integer.parseInt(id_interchange) ,Integer.parseInt(id_driver));
       }
       if(!id_conductor.isEmpty()){
           interchangeDAO.updateConductor(Integer.parseInt(id_interchange) ,Integer.parseInt(id_conductor));
       }
       if(!id_route_sheet.isEmpty()){
           interchangeDAO.updateRouteSheet(Integer.parseInt(id_interchange), Integer.parseInt(id_route_sheet));
       }
    }

    public void delete(String id_interchange) {
        interchangeDAO.delete(Integer.parseInt(id_interchange));
    }
}
