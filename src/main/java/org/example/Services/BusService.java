package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.Classes.Bus;
import org.example.DAO.BusDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusService {

    private final BusDAO busDAO;

    public List<Bus> getAll(){
        return (List<Bus>) busDAO.getAll();
    }

    public void setAll(String brand, int tail_number, String state_number){
        busDAO.setAll(brand, tail_number, state_number);
    }

    public void update(String id_bus, String brand, String state_number, String tail_number){
        if(!brand.isEmpty()) {
            busDAO.updateBrand(Integer.parseInt(id_bus), brand);
        }
        if (!tail_number.isEmpty()) {
                busDAO.updateTailNumber(Integer.parseInt(id_bus), Integer.parseInt(tail_number));
        }
        if (!state_number.isEmpty()) {
            busDAO.updateStateNumber(Integer.parseInt(id_bus), state_number);
        }

    }

    public void deleteBus(String id_bus){
        busDAO.deleteBus(Integer.parseInt(id_bus));
    }
}
