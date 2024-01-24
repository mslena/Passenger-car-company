package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Services.InterchangeService;
import org.example.Services.RequestService;
import org.example.Services.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final InterchangeService interchangeService;
    private final RouteService routeService;

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(SQLException ex, Model model) {
        model.addAttribute("error", "Ошибка " + ex.getMessage());
        return "errorPage";
    }


    @GetMapping("/Waybill")
    public ModelAndView waybill(@PathParam(value = "id_interchange") String id_interchange) {
        if(id_interchange != null){
            return new ModelAndView("Waybill").addObject("Waybill", requestService.waybill(id_interchange)).addObject("Interchange", interchangeService.getAll());
        }
        else{
            return new ModelAndView("Waybill").addObject("Interchange", interchangeService.getAll());
        }

    }

    @GetMapping("/requestOne")
    public ModelAndView requestOne(@PathParam(value = "date_g") String date_g) {
        if(date_g != null){
            return new ModelAndView("requestOne").addObject("requestOne",requestService.requestOne(date_g));
        }
        else {
            return new ModelAndView("requestOne");
        }
    }

    @GetMapping("/requestTwo")
    public ModelAndView requestTwo(@PathParam(value = "id_route") String id_route, @PathParam(value = "date_g") String date_g) {
        if(date_g != null){
            return new ModelAndView("requestTwo").addObject("requestTwo",requestService.requestTwo(id_route, date_g)).addObject("Route", routeService.getAll());
        }
        else {
            return new ModelAndView("requestTwo").addObject("Route", routeService.getAll());
        }
    }

    @GetMapping("/requestThree")
    public ModelAndView requestThree(@PathParam(value = "month") String month, Model model) {
        if(month != null){
            model.addAttribute("month", requestService.getNameMonth(month));
            return new ModelAndView("requestThree").addObject("requestThreeBus", requestService.requestThreeBus(month)).addObject("requestThreeRoute", requestService.requestThreeRoute(month));
        }
        else {
            return new ModelAndView("requestThree");
        }
    }

    @GetMapping("/requestFour")
    public ModelAndView requestFour(@PathParam(value = "start_month") String start_month, @PathParam(value = "end_month") String end_month, @PathParam(value = "year") String year, Model model) {
        if(start_month != null){
            model.addAttribute("start_month", requestService.getNameMonth(start_month));
            model.addAttribute("end_month", requestService.getNameMonth(end_month));
            model.addAttribute("year", year);
            return new ModelAndView("requestFour").addObject("requestFour", requestService.requestFour(start_month, end_month, year) );
        }
        else {
            return new ModelAndView("requestFour");
        }
    }
}
