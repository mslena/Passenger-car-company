package org.example.Controller;


import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class BusController {

    private BusService busService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Bus")
    public ModelAndView getAll() {
        return new ModelAndView("Bus").addObject("Bus", busService.getAll());
    }

    @GetMapping("/addBus")
    public ModelAndView setAll(@PathParam(value="brand") String brand,@PathParam(value="state_number") String state_number,@RequestParam(value="tail_number", defaultValue = "0") int tail_number) {
        if(brand != null){
            busService.setAll(brand, tail_number, state_number);
            return new ModelAndView("Bus").addObject("Bus", busService.getAll());
        }
        return new ModelAndView("addBus");
    }

    @GetMapping("/updateBus")
    public ModelAndView update(@PathParam(value="id_bus") String id_bus ,@PathParam(value="brand") String brand,@PathParam(value="state_number") String state_number,@PathParam(value="tail_number") String tail_number){
        if(brand != null){
            busService.update(id_bus, brand, state_number, tail_number);
            return new ModelAndView("Bus").addObject("Bus", busService.getAll());
        }
        return new ModelAndView("updateBus").addObject("Bus", busService.getAll());
    }

    @GetMapping("/deleteBus")
    public ModelAndView deleteBus(@PathParam(value="id_bus") String id_bus) {
        if(id_bus != null){
            busService.deleteBus(id_bus);
            return new ModelAndView("Bus").addObject("Bus", busService.getAll());
        }
        return new ModelAndView("deleteBus").addObject("Bus", busService.getAll());
    }
}