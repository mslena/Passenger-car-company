package org.example.Mapper;

import org.example.Classes.RequestThree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestThreeBusMapper implements RowMapper<RequestThree> {
    @Override
    public RequestThree mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestThree requestThree = new RequestThree();
        requestThree.setId_bus(rs.getInt("id_bus"));
        requestThree.setBrand(rs.getString("brand"));
        requestThree.setTail_number(rs.getInt("tail_number"));
        requestThree.setState_number(rs.getString("state_number"));
        requestThree.setCount(rs.getInt("count"));
        return requestThree;
    }
}
