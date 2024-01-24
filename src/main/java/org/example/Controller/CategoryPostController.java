package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.CategoryPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class CategoryPostController {
    private final CategoryPostService categoryPostService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/CategoryPost")
    public ModelAndView gelAll() {
        return new ModelAndView("/CategoryPost").addObject("CategoryPost", categoryPostService.getAll());
    }

    @GetMapping("/addCategoryPost")
    public ModelAndView setAll(@PathParam(value="name") String name) {
        if(name != null){
            categoryPostService.setAll(name);
            return new ModelAndView("CategoryPost").addObject("CategoryPost", categoryPostService.getAll());
        }
        return new ModelAndView("addCategoryPost");
    }

    @GetMapping("/updateCategoryPost")
    public ModelAndView update(@PathParam(value="id_category_post") String id_category_post, @PathParam(value="name") String name) {
        if(name != null){
            categoryPostService.update(id_category_post, name);
            return new ModelAndView("CategoryPost").addObject("CategoryPost", categoryPostService.getAll());
        }
        return new ModelAndView("updateCategoryPost").addObject("CategoryPost", categoryPostService.getAll());
    }

    @GetMapping("/deleteCategoryPost")
    public ModelAndView delete(@PathParam(value="id_category_post") String id_category_post) {
        if(id_category_post != null){
            categoryPostService.delete(id_category_post);
            return new ModelAndView("CategoryPost").addObject("CategoryPost", categoryPostService.getAll());
        }
        return new ModelAndView("deleteCategoryPost").addObject("CategoryPost", categoryPostService.getAll());
    }
}
