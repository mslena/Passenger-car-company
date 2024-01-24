package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.RouteMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RouteDAO implements DAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM route";
        return jdbcTemplate.query(SQL, new RouteMapper());
    }

    public void setAll(String start_route, String end_route, String dispatch_time, String arrival_time) {
        String SQL = "INSERT INTO route\n" +
                "(id_route, start_route, end_route, dispath_time, arrival_time) \n" +
                "VALUES (abs(dbms_random.random), ?,?,?,?)";
        jdbcTemplate.update(SQL, start_route, end_route, dispatch_time, arrival_time);
    }

    public void updateStartRoute(int id_route, String start_route) {
        String SQL = "UPDATE route\n" +
                "SET start_route = ?\n" +
                "WHERE id_route = ?";
        jdbcTemplate.update(SQL, start_route, id_route);
    }

    public void updateEndRoute(int id_route, String end_route) {
        String SQL = "UPDATE route\n" +
                "SET end_route = ?\n" +
                "WHERE id_route = ?";
        jdbcTemplate.update(SQL, end_route, id_route);
    }

    public void updateDispatchTime(int id_route, String dispatch_time) {
        String SQL = "UPDATE route\n" +
                "SET dispath_time = ?\n" +
                "WHERE id_route = ?";
        jdbcTemplate.update(SQL, dispatch_time, id_route);
    }

    public void updateArrivalTime(int id_route, String arrival_time) {
        String SQL = "UPDATE route\n" +
                "SET arrival_time = ? \n" +
                "WHERE id_route = ?";
        jdbcTemplate.update(SQL, arrival_time, id_route);
    }

    public void delete(int id_route) {
        String SQL = "DELETE FROM route\n" +
                "WHERE id_route = ?";
        jdbcTemplate.update(SQL, id_route);
    }
}
