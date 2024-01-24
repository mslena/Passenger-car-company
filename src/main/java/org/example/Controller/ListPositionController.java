package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.ListPositionService;
import org.example.Services.PostService;
import org.example.Services.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class ListPositionController {

    private final ListPositionService listPositionService;
    private final StaffService staffService;
    private final PostService postService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/ListPosition")
    public ModelAndView getAll() {
        return new ModelAndView("ListPosition").addObject("ListPosition", listPositionService.getAll());
    }

    @GetMapping("/addListPosition")
    public ModelAndView setAll(@PathParam(value = "id_staff") String id_staff, @PathParam(value = "id_post") String id_post, @PathParam(value = "work_experience") String work_experience, @PathParam(value = "salary") String salary) {
        if(id_staff != null){
            listPositionService.setAll(id_staff, id_post, work_experience, salary);
            return new ModelAndView("ListPosition").addObject("ListPosition", listPositionService.getAll());
        }
        return new ModelAndView("addListPosition").addObject("Staff", staffService.getAll()).addObject("Post", postService.getAll());
    }

    @GetMapping("/updateListPosition")
    public ModelAndView update(@PathParam(value = "id_staff") String id_staff, @PathParam(value = "id_post") String id_post, @PathParam(value = "work_experience") String work_experience, @PathParam(value = "salary") String salary) {
        if(id_staff != null){
            listPositionService.update(id_staff, id_post, work_experience, salary);
            return new ModelAndView("ListPosition").addObject("ListPosition", listPositionService.getAll());
        }
        return new ModelAndView("updateListPosition").addObject("Staff", staffService.getAll()).addObject("Post", postService.getAll());
    }

    @GetMapping("/deleteListPosition")
    public ModelAndView delete(@PathParam(value = "id_staff") String id_staff, @PathParam(value = "id_post") String id_post) {
        if(id_staff != null){
            listPositionService.delete(id_staff, id_post);
            return new ModelAndView("ListPosition").addObject("ListPosition", listPositionService.getAll());
        }
        return new ModelAndView("deleteListPosition").addObject("ListPosition", listPositionService.getAll());
    }
}
