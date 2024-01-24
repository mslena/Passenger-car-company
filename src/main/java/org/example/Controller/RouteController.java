package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/Route")
    public ModelAndView getAll() {
        return new ModelAndView("Route").addObject("Route", routeService.getAll());
    }

    @GetMapping("/addRoute")
    public ModelAndView setAll(@PathParam(value="start_route") String start_route, @PathParam(value="end_route") String end_route, @PathParam(value="dispatch_time") String dispatch_time, @PathParam(value="arrival_time") String arrival_time) {
        if(start_route != null) {
            routeService.setAll(start_route, end_route, dispatch_time, arrival_time);
            return new ModelAndView("Route").addObject("Route", routeService.getAll());
        }
        return new ModelAndView("addRoute");
    }

    @GetMapping("/updateRoute")
    public ModelAndView update(@PathParam(value="id_route") String id_route, @PathParam(value="start_route") String start_route, @PathParam(value="end_route") String end_route, @PathParam(value="dispatch_time") String dispatch_time, @PathParam(value="arrival_time") String arrival_time) {
        if(start_route != null) {
            routeService.update(id_route, start_route, end_route, dispatch_time, arrival_time);
            return new ModelAndView("Route").addObject("Route", routeService.getAll());
        }
        return new ModelAndView("updateRoute").addObject("Route", routeService.getAll());
    }

    @GetMapping("/deleteRoute")
    public ModelAndView delete (@PathParam(value="id_route") String id_route) {
        if (id_route != null) {
            routeService.delete(id_route);
            return new ModelAndView("Route").addObject("Route", routeService.getAll());
        }
        return new ModelAndView("deleteRoute").addObject("Route", routeService.getAll());
    }
}
