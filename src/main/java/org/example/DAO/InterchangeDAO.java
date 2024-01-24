package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.InterchangeMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class InterchangeDAO implements DAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM interchange";
        return jdbcTemplate.query(SQL, new InterchangeMapper());
    }

    public void setAll(int id_driver, int id_conductor, int id_route_sheet) {
        String SQL = "INSERT INTO interchange\n" +
                "(id_interchange, id_driver, id_conductor, id_route_sheet)\n" +
                "VALUES (abs(dbms_random.random),?,?,?)";
        jdbcTemplate.update(SQL, id_driver, id_conductor, id_route_sheet);
    }

    public void updateDriver(int id_interchange, int id_driver) {
        String SQL = "UPDATE interchange\n" +
                "SET id_driver = ?\n" +
                "WHERE id_interchange = ?";
        jdbcTemplate.update(SQL, id_driver, id_interchange);
    }

    public void updateConductor(int id_interchange, int id_conductor) {
        String SQL = "UPDATE interchange\n" +
                "SET id_conductor = ?\n" +
                "WHERE id_interchange = ?";
        jdbcTemplate.update(SQL, id_conductor, id_interchange);
    }

    public void updateRouteSheet(int id_interchange, int id_route_sheet) {
        String SQL = "UPDATE interchange\n" +
                "SET id_route_sheet = ?\n" +
                "WHERE id_interchange = ?";
        jdbcTemplate.update(SQL, id_route_sheet, id_interchange);
    }

    public void delete(int id_interchange) {
        String SQL = "DELETE FrOM interchange\n" +
                "WHERE id_interchange = ?";
        jdbcTemplate.update(SQL, id_interchange);
    }
}
