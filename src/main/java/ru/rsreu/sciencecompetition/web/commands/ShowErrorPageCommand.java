package ru.rsreu.sciencecompetition.web.commands;

import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowErrorPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(ConfigurationManagers.WEB_MANAGER.getProperty("page.error")).forward(request, response);
    }
}
