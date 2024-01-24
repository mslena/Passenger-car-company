package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.InterchangeService;
import org.example.Services.RouteSheetService;
import org.example.Services.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class InterchangeController {

    private final InterchangeService interchangeService;
    private final RouteSheetService routeSheetService;
    private final StaffService staffServices;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Interchange")
    public ModelAndView getAll(){
        return new ModelAndView("Interchange").addObject("Interchange", interchangeService.getAll());
    }

    @GetMapping("/addInterchange")
    public ModelAndView setAll(@PathParam(value = "id_driver") String id_driver, @PathParam(value = "id_conductor") String id_conductor, @PathParam(value = "id_route_sheet") String id_route_sheet){
        if(id_driver != null) {
            interchangeService.setAll(id_driver, id_conductor, id_route_sheet);
            return new ModelAndView("Interchange").addObject("Interchange", interchangeService.getAll());
        }
        return new ModelAndView("addInterchange").addObject("RouteSheet", routeSheetService.getAll()).addObject("Staff", staffServices.getAll());
    }

    @GetMapping("/updateInterchange")
    public ModelAndView update(@PathParam(value = "id_interchange") String id_interchange, @PathParam(value = "id_driver") String id_driver, @PathParam(value = "id_conductor") String id_conductor, @PathParam(value = "id_route_sheet") String id_route_sheet){
        if(id_driver != null) {
            interchangeService.updateAll(id_interchange, id_driver, id_conductor, id_route_sheet);
            return new ModelAndView("Interchange").addObject("Interchange", interchangeService.getAll());
        }
        return new ModelAndView("updateInterchange").addObject("RouteSheet", routeSheetService.getAll()).addObject("Staff", staffServices.getAll()).addObject("Interchange", interchangeService.getAll());
    }

    @GetMapping("/deleteInterchange")
    public ModelAndView delete(@PathParam(value = "id_interchange") String id_interchange){
        if(id_interchange != null)
        {
            interchangeService.delete(id_interchange);
            return new ModelAndView("Interchange").addObject("Interchange", interchangeService.getAll());
        }
        return new ModelAndView("deleteInterchange").addObject("Interchange", interchangeService.getAll());
    }
}
