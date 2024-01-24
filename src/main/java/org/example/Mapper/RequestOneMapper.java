package org.example.Mapper;

import org.example.Classes.RequestOne;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestOneMapper implements RowMapper<RequestOne> {

    @Override
    public RequestOne mapRow(ResultSet rs, int rowNum) throws SQLException {
        RequestOne requestOne = new RequestOne();
        requestOne.setId_route(rs.getInt("id_route"));
        requestOne.setCount(rs.getInt("count"));
        requestOne.setDate_g(rs.getDate("date_g"));
        return requestOne;
    }
}
