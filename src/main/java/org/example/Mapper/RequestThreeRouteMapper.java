package org.example.Mapper;

import org.example.Classes.RequestThree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestThreeRouteMapper implements RowMapper<RequestThree> {

    @Override
    public RequestThree mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestThree requestThree = new RequestThree();
        requestThree.setId_route(rs.getInt("id_route"));
        requestThree.setCount(rs.getInt("count"));
        return requestThree;
    }
}
