package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.CategoryPost;
import org.example.Interface.DAO;
import org.example.Mapper.CategoryPostMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CategoryPostDAO implements DAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT id_category_post, name as name_p FROM CATEGORY_POST";
        List<CategoryPost> categoryPost =jdbcTemplate.query(SQL, new CategoryPostMapper());
        return categoryPost;
    }

    public int setAll(String name) {
        String SQL = "insert into category_post\n" +
                "(id_category_post, name) values (abs(dbms_random.random), ?)";
        return jdbcTemplate.update(SQL, name);
    }

    public void updateAll(int id_category_post, String name){
        String SQL = "UPDATE category_post\n" +
                "SET name=? \n" +
                "WHERE id_category_post=?";
        jdbcTemplate.update(SQL, name, id_category_post);
    }

    public void delete(int id_category_post){
        String SQL = "delete from category_post \n" +
                "where id_category_post = ?";
        jdbcTemplate.update(SQL, id_category_post);
    }
}
