package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("cars")
    public String getAllCars(ModelMap model) {
        List<Car> list = carService.getAllCars();
        List<String> messages = new ArrayList<>();
        StringBuilder s;
        for (Car c : list) {
            messages.add(c.getModel() + " " + c.getColor() + " " + c.getYear());
        }
        model.addAttribute("messages", messages);
        return "cars";
    }

    @GetMapping("cars/{count}")
    public String getCars(ModelMap model, @PathVariable int count) {
        if(count>=5) carService.getAllCars();
        List<Car> list = carService.getAllCarsByCount(count);
        List<String> messages = new ArrayList<>();
        for (Car c : list) {
            messages.add(c.getModel() + " " + c.getColor() + " " + c.getYear());
        }
        model.addAttribute("messages", messages);
        return "cars";
    }
}
