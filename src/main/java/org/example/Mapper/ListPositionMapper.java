package org.example.Mapper;

import org.example.Classes.ListPosition;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListPositionMapper implements RowMapper<ListPosition> {
    @Override
    public ListPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
        ListPosition listPosition = new ListPosition();
        listPosition.setId_post(rs.getInt("id_post"));
        listPosition.setId_staff(rs.getInt("id_staff"));
        listPosition.setWork_experience(rs.getInt("work_experience"));
        listPosition.setSalary(rs.getString("salary"));
        return listPosition;
    }
}
