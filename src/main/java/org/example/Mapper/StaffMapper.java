package org.example.Mapper;

import org.example.Classes.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        Staff staff = new Staff();
        staff.setId_staff(rs.getInt("id_staff"));
        staff.setAddress(rs.getString("address"));
        staff.setDate_of_birth(rs.getDate("date_of_birth"));
        staff.setFull_name(rs.getString("full_name"));
        staff.setPhone_number(rs.getString("phone_number"));
        staff.setPassport_details(rs.getString("passport_details"));
        staff.setWork_book_number(rs.getString("work_book_number"));
        return staff;
    }
}
