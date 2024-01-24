package org.example.Mapper;

import org.example.Classes.Bus;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusMapper implements RowMapper<Bus> {

    @Override
    public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bus bus = new Bus();
        bus.setId_bus(rs.getInt("ID_Bus"));
        bus.setBrand(rs.getString("Brand"));
        bus.setState_number(rs.getString("State_number"));
        bus.setTail_number(rs.getInt("Tail_number"));
        return bus;
    }
}
