package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class StaffController {

    private final StaffService staffServices;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Staff")
    public ModelAndView getAll(){
        return new ModelAndView("Staff").addObject("Staff", staffServices.getAll());
    }

    @GetMapping("/addStaff")
    public ModelAndView setAll(@PathParam(value="full_name") String full_name, @PathParam(value="date_of_birth") String date_of_birth, @PathParam(value="phone_number") String phone_number, @PathParam(value="address") String address, @PathParam(value="passport_details") String passport_details, @PathParam(value="work_book_number") String work_book_number){
        if (full_name != null){
            staffServices.setAll(full_name, date_of_birth, phone_number, address, passport_details, work_book_number);
            return new ModelAndView("Staff").addObject("Staff", staffServices.getAll());
        }
        return new ModelAndView("addStaff");
    }

    @GetMapping("/updateStaff")
    public ModelAndView update(@PathParam(value="id_staff") String id_staff, @PathParam(value="full_name") String full_name, @PathParam(value="date_of_birth") String date_of_birth, @PathParam(value="phone_number") String phone_number, @PathParam(value="address") String address, @PathParam(value="passport_details") String passport_details, @PathParam(value="work_book_number") String work_book_number){
        if (full_name != null){
            staffServices.update(id_staff, full_name, date_of_birth, phone_number, address, passport_details, work_book_number);
            return new ModelAndView("Staff").addObject("Staff", staffServices.getAll());
        }
        return new ModelAndView("updateStaff").addObject("Staff", staffServices.getAll());
    }

    @GetMapping("/deleteStaff")
    public ModelAndView delete(@PathParam(value="id_staff") String id_staff){
        if (id_staff != null){
            staffServices.delete(id_staff);
            return new ModelAndView("Staff").addObject("Staff", staffServices.getAll());
        }
        return new ModelAndView("deleteStaff").addObject("Staff", staffServices.getAll());
    }
}
