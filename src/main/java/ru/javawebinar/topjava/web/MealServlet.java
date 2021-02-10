package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.Main;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import ru.javawebinar.topjava.model.MealTo;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    List<Meal> meals = Main.meals;
    List<MealTo> mealsList = MealsUtil.filteredByStreams(meals, LocalTime.of(0, 0), LocalTime.of(23, 59), 2000);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        // request.setAttribute("list", mealsList);

        // getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);    // получаем Request Dispatcher (Диспетчер Запросов) и указываем ему jsp страницу которая будет отображаться при обращении к данному методуGET. Метод forward(req, resp) перенаправляет наш запрос на jsp страницу.

        // response.sendRedirect("meals.jsp");
        /* testing
        request.setAttribute("name", "Tom");
        request.setAttribute("age", 34);
        getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);
         */

        String[] users = new String[]{"Tom", "Bob", "Sam"};
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
