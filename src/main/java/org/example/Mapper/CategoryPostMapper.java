package org.example.Mapper;

import org.example.Classes.CategoryPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryPostMapper implements RowMapper<CategoryPost> {
    @Override
    public CategoryPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryPost categoryPost = new CategoryPost();
        categoryPost.setId_category_post(rs.getInt("id_category_post"));
        categoryPost.setName(rs.getString("name_p"));
        return categoryPost;
    }
}
