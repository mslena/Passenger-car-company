package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Bus;
import org.example.Interface.DAO;
import org.example.Mapper.BusMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class BusDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM BUS";
        List<Bus> bus =jdbcTemplate.query(SQL, new BusMapper());
        return bus;
    }

    public int setAll(String brand, int tail_number, String state_number) {
        String SQL = "insert into bus\n" +
                "(id_bus, brand, state_number, tail_number) values (abs(dbms_random.random), ?,?,?)";
        return jdbcTemplate.update(SQL, brand, state_number, tail_number);
    }

    public int updateBrand(int id_bus,String brand){
        String SQL="UPDATE bus\n" +
                "SET brand=?\n" +
                "WHERE id_bus=?";
        return jdbcTemplate.update(SQL, brand, id_bus);
    }

    public int updateTailNumber(int id_bus, int tail_number){
        String SQL="UPDATE bus\n" +
                "SET tail_number=?\n" +
                "WHERE id_bus=?";
        return jdbcTemplate.update(SQL, tail_number, id_bus);
    }

    public int updateStateNumber(int id_bus, String state_number){
        String SQL="UPDATE bus\n" +
                "SET state_number=?\n" +
                "WHERE id_bus=?";
        return jdbcTemplate.update(SQL, state_number, id_bus);
    }

    public int deleteBus (int id_bus){
        String SQL = "DELETE FROM BUS\n" +
                "WHERE ID_BUS = ?";
        return jdbcTemplate.update(SQL, id_bus);
    }
}
