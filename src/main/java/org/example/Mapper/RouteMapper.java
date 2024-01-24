package org.example.Mapper;

import org.example.Classes.Route;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteMapper implements RowMapper<Route> {
    @Override
    public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
        Route route = new Route();
        route.setId_route(rs.getInt("id_route"));
        route.setEnd_route(rs.getString("end_route"));
        route.setStart_route(rs.getString("start_route"));
        route.setArrival_time(rs.getString("arrival_time"));
        route.setDispatch_time(rs.getString("dispath_time"));
        return route;
    }
}
