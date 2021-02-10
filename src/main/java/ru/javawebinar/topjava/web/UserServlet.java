package ru.javawebinar.topjava.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to users");

//        request.getRequestDispatcher("/users.jsp").forward(request, response);    // получаем Request Dispatcher (Диспетчер Запросов) и указываем ему jsp страницу которая будет отображаться при обращении к данному методуGET. Метод forward(req, resp) перенаправляет наш запрос на jsp страницу.
        response.sendRedirect("users.jsp");
    }
}
