package com.example.restaurant.controller.EJB;

import com.example.restaurant.controller.command.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Objects;
import javax.servlet.ServletException;

@Stateful
public class CommandService {
    private Map<String, Command> commands = new HashMap<>();
    private static final Logger log = LogManager.getLogger();

    public void setCommands(Map<String, Command> commandsToLoad) {
        commands = commandsToLoad;
    }

    public void executeCommand(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String path = request.getRequestURI().replaceFirst(request.getContextPath() + "/app", "");
        log.info("Current path: " + path);
        Command command = commands.getOrDefault(path,
                (r) -> "/WEB-INF/view/menu.jsp");

        log.info("Current command: " + command.getClass().getSimpleName());
        String page = null;
        try {
            page = command.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Objects.requireNonNull(page).contains("redirect")) {
            response.sendRedirect(request.getContextPath() + request.getServletPath() + page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}