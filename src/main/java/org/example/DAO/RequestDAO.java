package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Mapper.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RequestDAO {

    private final JdbcTemplate jdbcTemplate;

    public List waybill(int id_interchange){
        String SQL = "SELECT route.dispath_time, route.arrival_time, bus.brand, bus.tail_number, bus.state_number, route.start_route, route.end_route, route_sheet.date_g, interchange.id_interchange, t2.full_name as full_name_driver, t3.full_name as full_name_conductor, t2.phone_number as phone_number_driver, t3.phone_number as phone_number_conductor FROM route_sheet\n" +
                "JOIN route\n" +
                "ON route.id_route = route_sheet.id_route\n" +
                "JOIN bus\n" +
                "ON route_sheet.id_bus = bus.id_bus\n" +
                "JOIN interchange\n" +
                "ON interchange.id_route_sheet = route_sheet.id_route_sheet\n" +
                "JOIN  staff t2\n" +
                "ON interchange.id_driver = t2.id_staff\n" +
                "JOIN  staff t3\n" +
                "ON interchange.id_conductor = t3.id_staff\n" +
                "WHERE id_interchange = ?";
        return jdbcTemplate.query(SQL, new WaybillMapper(), id_interchange);
    }

    public List requestOne(String date_g) {
        String SQL="select count(id_bus) as count, route.id_route, route_sheet.date_g from route\n" +
                "join route_sheet on route.id_route = route_sheet.id_route\n" +
                "where route_sheet.date_g = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "group by route.id_route, route_sheet.date_g";
        return jdbcTemplate.query(SQL, new RequestOneMapper(), date_g);
    }

    public List requestTwo(String id_route,String date_g){
        String SQL = "select route.id_route, route_sheet.date_g, bus.brand, bus.tail_number, bus.state_number from route\n" +
                "join route_sheet on route.id_route = route_sheet.id_route\n" +
                "join bus on bus.id_bus = route_sheet.id_bus\n" +
                "where route_sheet.date_g = TO_DATE(? ,'YYYY-MM-DD') and route.id_route = ?\n" +
                "group by route.id_route, route_sheet.date_g, bus.brand, bus.tail_number, bus.state_number";
        return jdbcTemplate.query(SQL, new RequestTwoMapper(), date_g, id_route);
    }

    public List requestThreeBus(String month){
        String SQL = "select count(route_sheet.id_route_sheet) as count, bus.id_bus, bus.brand, bus.tail_number, bus.state_number from route_sheet\n" +
                "join bus on bus.id_bus = route_sheet.id_bus\n" +
                "WHERE EXTRACT(MONTH FROM date_g) = ?\n" +
                "group by bus.id_bus, bus.brand, bus.tail_number, bus.state_number";
        return jdbcTemplate.query(SQL, new RequestThreeBusMapper(), month);
    }

    public List requestThreeRoute(String month){
        String SQL = "select count(route_sheet.id_route_sheet) as count, route_sheet.id_route from route_sheet\n" +
                "join bus on bus.id_bus = route_sheet.id_bus\n" +
                "WHERE EXTRACT(MONTH FROM date_g) = ?\n" +
                "group by route_sheet.id_route";
        return jdbcTemplate.query(SQL, new RequestThreeRouteMapper(), month);
    }

    public List requestFour(String start_month, String end_month, String year){
        String SQL = "select count(id_conductor) as count_conductor, id_conductor, count(id_driver)as count_driver, id_driver, t2.full_name as full_name_driver, t3.full_name as full_name_conductor from interchange\n" +
                "join route_sheet on interchange.id_route_sheet = route_sheet.id_route_sheet\n" +
                "JOIN staff t2\n" +
                "ON interchange.id_driver = t2.id_staff\n" +
                "JOIN staff t3\n" +
                "ON interchange.id_conductor = t3.id_staff\n" +
                "WHERE\n" +
                "    EXTRACT(MONTH FROM route_sheet.date_g) BETWEEN ? AND ?\n" +
                "    AND EXTRACT(YEAR FROM route_sheet.date_g) = ?\n" +
                "group by id_conductor, id_driver, t2.full_name, t3.full_name";
        return jdbcTemplate.query(SQL, new RequestFourMapper(), start_month, end_month, year);
    }
}
