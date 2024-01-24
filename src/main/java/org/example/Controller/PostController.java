package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.CategoryPostService;
import org.example.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final CategoryPostService categoryPostService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Post")
    public ModelAndView gelAll() {
        return new ModelAndView("/Post").addObject("Post", postService.getAll());
    }

    @GetMapping("/addPost")
    public ModelAndView setAll(@PathParam(value="name") String name, @PathParam(value="id_category_post") String id_category_post) {
        if(name != null){
            postService.setAll(name, id_category_post);
            return new ModelAndView("Post").addObject("Post", postService.getAll());
        }
        return new ModelAndView("addPost").addObject("CategoryPost", categoryPostService.getAll());
    }

    @GetMapping("/updatePost")
    public ModelAndView update(@PathParam(value="id_post") String id_post, @PathParam(value="name") String name, @PathParam(value="id_category_post") String id_category_post) {
        if(id_category_post != null){
            postService.update(id_post, name, id_category_post);
            return new ModelAndView("Post").addObject("Post", postService.getAll());
        }
        return new ModelAndView("updatePost").addObject("Post", postService.getAll());
    }

    @GetMapping("/deletePost")
    public ModelAndView delete(@PathParam(value="id_post") String id_post){
        if(id_post != null){
            postService.delete(id_post);
            return new ModelAndView("Post").addObject("Post", postService.getAll());
        }
        return new ModelAndView("deletePost").addObject("Post", postService.getAll());
    }
}
