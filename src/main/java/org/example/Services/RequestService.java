package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DAO.RequestDAO;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestDAO requestDAO;

    public List waybill(String id_interchange){
        return requestDAO.waybill(Integer.parseInt(id_interchange));
    }

    public List requestOne(String date_g) { return requestDAO.requestOne(date_g); }

    public List requestTwo(String id_route, String date_g) { return requestDAO.requestTwo(id_route, date_g); }

    public List requestThreeBus(String month) { return requestDAO.requestThreeBus(month); }

    public List requestThreeRoute(String month) { return requestDAO.requestThreeRoute(month); }

    public String getNameMonth(String monthNumber) {
        try {
            if (Integer.parseInt(monthNumber) >= 1 && Integer.parseInt(monthNumber) <= 12) {
                Month month = Month.of(Integer.parseInt(monthNumber));
                return month.toString();
            } else {
                return "Неверный номер месяца";
            }
        } catch (Exception e) {
            return "Ошибка при преобразовании месяца";
        }
    }

    public List requestFour(String start_month, String end_month, String year) { return requestDAO.requestFour(start_month, end_month, year); }

}
