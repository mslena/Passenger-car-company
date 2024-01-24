package org.example.Mapper;

import org.example.Classes.Waybill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WaybillMapper implements RowMapper<Waybill> {
    @Override
    public Waybill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Waybill waybill = new Waybill();
        waybill.setId_interchange(rs.getInt("id_interchange"));
        waybill.setTail_number(rs.getInt("tail_number"));
        waybill.setDate_g(rs.getDate("date_g"));
        waybill.setBrand(rs.getString("brand"));
        waybill.setEnd_route(rs.getString("end_route"));
        waybill.setStart_route(rs.getString("start_route"));
        waybill.setState_number(rs.getString("state_number"));
        waybill.setFull_name_conductor(rs.getString("full_name_conductor"));
        waybill.setFull_name_driver(rs.getString("full_name_driver"));
        waybill.setPhone_number_conductor(rs.getString("phone_number_conductor"));
        waybill.setPhone_number_driver(rs.getString("phone_number_driver"));
        waybill.setArrival_time(rs.getString("arrival_time"));
        waybill.setDispath_time(rs.getString("dispath_time"));
        return waybill;
    }
}
