package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.BusService;
import org.example.Services.RouteService;
import org.example.Services.RouteSheetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class RouteSheetController {

    private final RouteService routeService;
    private final BusService busService;
    private final RouteSheetService routeSheetService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage"; // имя представления для отображения ошибки
    }

    @GetMapping("/RouteSheet")
    public ModelAndView getAll() {
        return new ModelAndView("RouteSheet").addObject("RouteSheet", routeSheetService.getAll());
    }

    @GetMapping("/addRouteSheet")
    public ModelAndView setAll(@PathParam(value = "id_route") String id_route, @PathParam(value = "id_bus") String id_bus, @PathParam(value = "date") String date) {
        if(id_route != null){
            routeSheetService.setAll(id_route, id_bus, date);
            return new ModelAndView("RouteSheet").addObject("RouteSheet", routeSheetService.getAll());
        }
        return new ModelAndView("addRouteSheet").addObject("Route", routeService.getAll()).addObject("Bus", busService.getAll());
    }

    @GetMapping("/updateRouteSheet")
    public ModelAndView update(@PathParam(value = "id_route_sheet") String id_route_sheet,@PathParam(value = "id_route") String id_route, @PathParam(value = "id_bus") String id_bus, @PathParam(value = "date") String date) {
        if(id_route != null){
            routeSheetService.update(id_route_sheet, id_route, id_bus, date);
            return new ModelAndView("RouteSheet").addObject("RouteSheet", routeSheetService.getAll());
        }
        return new ModelAndView("updateRouteSheet").addObject("Route", routeService.getAll()).addObject("Bus", busService.getAll()).addObject("RouteSheet", routeSheetService.getAll());
    }

    @GetMapping("/deleteRouteSheet")
    public ModelAndView delete(@PathParam(value = "id_route_sheet") String id_route_sheet) {
        if(id_route_sheet != null){
            routeSheetService.delete(id_route_sheet);
            return new ModelAndView("RouteSheet").addObject("RouteSheet", routeSheetService.getAll());
        }
        return new ModelAndView("deleteRouteSheet").addObject("RouteSheet", routeSheetService.getAll());
    }
}
