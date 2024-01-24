package org.example.Mapper;

import org.example.Classes.RequestTwo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestTwoMapper implements RowMapper<RequestTwo> {
    @Override
    public RequestTwo mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestTwo requestTwo = new RequestTwo();
        requestTwo.setId_route(rs.getInt("id_route"));
        requestTwo.setTail_number(rs.getInt("tail_number"));
        requestTwo.setDate_g(rs.getDate("date_g"));
        requestTwo.setBrand(rs.getString("brand"));
        requestTwo.setState_number(rs.getString("state_number"));
        return requestTwo;
    }
}
