package ru.rsreu.sciencecompetition.web.commands.guest;

import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManager;
import ru.rsreu.sciencecompetition.web.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowLoginPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ConfigurationManager.getProperty("page.login")).forward(req, resp);
    }
}
