package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/meals")
public class JspMealController {

    @Autowired
    private MealService service;

    @GetMapping("/")
    public String getMeals(Model model) {
        model.addAttribute("mealsAttribute", service.getAll(100000)); // TODO add userId in service.getAll()
        return "meals";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("meal", new Meal());
        return "mealForm";
    }


    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Meal meal = service.get(id, 100000);
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id, 100000);
        return "redirect:meals";
    }
    
    @PostMapping
    public String creatAndUpdate(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Meal meal = new Meal(id,
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if(meal.isNew()) {
            service.create(meal, 100000);
        } else {
            service.update(meal, 100000);
        }

        return "redirect:meals";
    }
}
