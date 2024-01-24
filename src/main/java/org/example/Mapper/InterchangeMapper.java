package org.example.Mapper;

import org.example.Classes.Interchange;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterchangeMapper implements RowMapper<Interchange> {
    @Override
    public Interchange mapRow(ResultSet rs, int rowNum) throws SQLException {
        Interchange interchange = new Interchange();
        interchange.setId_interchange(rs.getInt("id_interchange"));
        interchange.setId_conductor(rs.getInt("id_conductor"));
        interchange.setId_driver(rs.getInt("id_driver"));
        interchange.setId_route_sheet(rs.getInt("id_route_sheet"));
        return interchange;
    }
}
