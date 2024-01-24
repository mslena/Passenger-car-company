package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.Classes.Post;
import org.example.DAO.CategoryPostDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryPostService {
    private final CategoryPostDAO categoryPostDAO;

    public List<Post> getAll(){
        return (List<Post>) categoryPostDAO.getAll();
    }

    public void setAll(String name){
        categoryPostDAO.setAll(name);
    }

    public void update(String id_category_post, String name){
        if(name != "") {
            categoryPostDAO.updateAll(Integer.parseInt(id_category_post), name);
        }
    }

    public void delete(String id_category_post){
        categoryPostDAO.delete(Integer.parseInt(id_category_post));
    }
}
