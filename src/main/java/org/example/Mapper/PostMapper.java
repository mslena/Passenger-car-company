package org.example.Mapper;


import org.example.Classes.Post;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements  RowMapper<Post>{

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId_post(rs.getInt("id_post"));
        post.setId_category_post(rs.getInt("id_category_post"));
        post.setName(rs.getString("name"));
        return post;
    }
}
