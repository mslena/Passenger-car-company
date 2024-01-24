package org.example.Mapper;

import org.example.Classes.RequestFour;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestFourMapper implements RowMapper<RequestFour> {
    @Override
    public RequestFour mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestFour requestFour = new RequestFour();
        requestFour.setId_driver(rs.getInt("id_driver"));
        requestFour.setCount_driver(rs.getInt("count_driver"));
        requestFour.setId_conductor(rs.getInt("id_conductor"));
        requestFour.setCount_conductor(rs.getInt("count_conductor"));
        requestFour.setFull_name_driver(rs.getString("full_name_driver"));
        requestFour.setFull_name_conductor(rs.getString("full_name_conductor"));
        return requestFour;
    }
}
