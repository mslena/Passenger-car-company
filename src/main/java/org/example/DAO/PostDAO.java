package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Post;
import org.example.Interface.DAO;
import org.example.Mapper.PostMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PostDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List getAll() {
        String SQL = "SELECT * FROM POST";
        List<Post> post =jdbcTemplate.query(SQL, new PostMapper());
        return post;
    }

    public int setAll(String name, int id_category_post) {
        String SQL = "insert into post\n" +
                "(id_post, name, id_category_post) values (abs(dbms_random.random), ?,?)";
        return jdbcTemplate.update(SQL, name, id_category_post);
    }

    public void updateName(int id_post, String name){
        String SQL = "update post\n" +
                "SET name = ? \n" +
                "WHERE id_post = ?";
        jdbcTemplate.update(SQL, name, id_post);
    }
    public void updateIdCategoryPost(int id_post, int id_category_post){
        String SQL = "update post\n" +
                "SET id_category_post = ? \n" +
                "WHERE id_post = ?";
        jdbcTemplate.update(SQL, id_category_post, id_post);
    }

    public void delete(int id_post){
        String SQL = "delete from post \n" +
                "where id_post = ?";
        jdbcTemplate.update(SQL, id_post);
    }
}
