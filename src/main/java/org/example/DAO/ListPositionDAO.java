package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.ListPositionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ListPositionDAO implements DAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM list_position";
        return jdbcTemplate.query(SQL, new ListPositionMapper());
    }

    public void setAll(int id_staff, int id_post, String work_experience, String salary) {
        String SQL = "INSERT INTO list_position\n" +
                "(id_staff, id_post, work_experience, salary)\n" +
                "VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, id_staff, id_post, work_experience, salary);
    }



    public void updateWorkExperience(int id_staff, int id_post, String work_experience) {
        String SQL = "UPDATE list_position\n" +
                "SET work_experience = ?\n" +
                "WHERE id_staff = ? AND id_post = ?";
        jdbcTemplate.update(SQL, work_experience, id_staff, id_post);
    }

    public void updateSalary(int id_staff, int id_post, String salary) {
        String SQL = "UPDATE list_position\n" +
                "SET salary = ?\n" +
                "WHERE id_staff = ? AND id_post = ?";
        jdbcTemplate.update(SQL, salary, id_staff, id_post);
    }

    public void delete(int id_staff, int id_post) {
        String SQL = "DELETE FROM list_position\n" +
                "WHERE id_staff = ? AND id_post = ?";
        jdbcTemplate.update(SQL, id_staff, id_post);
    }
}
