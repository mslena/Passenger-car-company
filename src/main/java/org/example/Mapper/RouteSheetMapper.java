package org.example.Mapper;

import org.example.Classes.RouteSheet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteSheetMapper implements RowMapper<RouteSheet> {
    @Override
    public RouteSheet mapRow(ResultSet rs, int rowNum) throws SQLException {
        RouteSheet routeSheet = new RouteSheet();
        routeSheet.setId_route_sheet(rs.getInt("id_route_sheet"));
        routeSheet.setDate(rs.getDate("DATE_G"));
        routeSheet.setId_route(rs.getInt("id_route"));
        routeSheet.setId_bus(rs.getInt("id_bus"));
        return routeSheet;
    }
}
