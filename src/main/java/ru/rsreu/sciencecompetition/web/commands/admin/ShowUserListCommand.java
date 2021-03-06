package ru.rsreu.sciencecompetition.web.commands.admin;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.Roles;
import ru.rsreu.sciencecompetition.datalayer.dto.User;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ShowUserListCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        List<User> admin_users = daoFactory.getUserDAO().getAllByRole(Roles.ADMINISTRATOR);
        List<User> expert_users = daoFactory.getUserDAO().getAllByRole(Roles.EXPERT);
        List<User> participant_users = daoFactory.getUserDAO().getAllByRole(Roles.PARTICIPANT);

        sortByAccountStatus(admin_users);
        sortByAccountStatus(expert_users);
        sortByAccountStatus(participant_users);

        request.setAttribute("admin_users", admin_users);
        request.setAttribute("expert_users", expert_users);
        request.setAttribute("participant_users", participant_users);

        request.getRequestDispatcher(ConfigurationManagers.WEB_MANAGER.getProperty("page.admin.userList")).forward(request, response);
    }

    private void sortByAccountStatus(List<User> users){
        users.sort(Comparator.comparingInt(user -> user.getStatus().getId()));
    }
}
