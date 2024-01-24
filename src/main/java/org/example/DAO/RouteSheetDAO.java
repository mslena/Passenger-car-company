package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.RouteSheetMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RouteSheetDAO implements DAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM route_sheet";
        return jdbcTemplate.query(SQL, new RouteSheetMapper());
    }

    public void setAll(int id_route, int id_bus, String date) {
        String SQL = "INSERT INTO route_sheet\n" +
                "(id_route_sheet, id_route, id_bus, date_g)\n" +
                "VALUES (abs(dbms_random.random), ?, ?, TO_DATE(? ,'YYYY-MM-DD'))";
        jdbcTemplate.update(SQL, id_route, id_bus, date);
    }

    public void updateIdRoute(int id_route_sheet,int id_route) {
        String SQL = "UPDATE route_sheet\n" +
                "SET id_route = ?\n" +
                "WHERE id_route_sheet = ?";
        jdbcTemplate.update(SQL, id_route, id_route_sheet);
    }

    public void updateIdBus(int id_route_sheet, int id_bus) {
        String SQL = "UPDATE route_sheet\n" +
                "SET id_bus = ?\n" +
                "WHERE id_route_sheet = ?";
        jdbcTemplate.update(SQL,id_bus, id_route_sheet);
    }

    public void updateDate(int id_route_sheet, String date) {
        String SQL = "UPDATE route_sheet\n" +
                "SET date_g = TO_DATE(? ,'YYYY-MM-DD')\n" +
                "WHERE id_route_sheet = ?";
        jdbcTemplate.update(SQL, date, id_route_sheet);
    }

    public void delete(int id_route_sheet) {
        String SQL = "DELETE FROM route_sheet\n" +
                "WHERE id_route_sheet = ?";
        jdbcTemplate.update(SQL, id_route_sheet);
    }
}
