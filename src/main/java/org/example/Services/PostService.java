package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.Classes.Post;
import org.example.DAO.PostDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostDAO postDAO;

    public List<Post> getAll(){
        return (List<Post>) postDAO.getAll();
    }

    public void setAll(String name, String id_category_post){
        postDAO.setAll(name, Integer.parseInt(id_category_post));
    }

    public void update(String id_post, String name, String id_category_post){
        if(!id_category_post.isEmpty()){
            postDAO.updateIdCategoryPost(Integer.parseInt(id_post), Integer.parseInt(id_category_post));
        }
        if(!name.isEmpty()){
            postDAO.updateName(Integer.parseInt(id_post), name);
        }
    }

    public void delete(String id_post){
        postDAO.delete(Integer.parseInt(id_post));
    }
}
