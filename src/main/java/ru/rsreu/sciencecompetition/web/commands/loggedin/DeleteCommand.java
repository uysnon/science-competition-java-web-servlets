package ru.rsreu.sciencecompetition.web.commands.loggedin;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.Roles;
import ru.rsreu.sciencecompetition.datalayer.dto.User;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.Command;
import ru.rsreu.sciencecompetition.web.commands.CommandEnum;
import ru.rsreu.sciencecompetition.web.commands.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand implements Command {
    private static final String NO_SUCH_ROLE = "Нельзя удалять учетную запись от имени незарегистрированного пользователя";
    private static final String EMPTY_DELETE_USER = "Удаляемая учетная запись не существует";

    private static final String CANT_DELETE = "Нет прав для удаления выбранной учетной записи";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        User currentUser = daoFactory.getUserDAO().get((String) request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.login")));
        String userLoginToDelete = request.getParameter("user_login");
        User userToDelete = daoFactory.getUserDAO().get(userLoginToDelete);

        if (currentUser == null) {
            request.setAttribute("errorMessage", NO_SUCH_ROLE);
            request.getRequestDispatcher(UrlUtils.getCommandUrl(CommandEnum.SHOW_ERROR_PAGE.name())).forward(request, response);
            return;
        }

        if (userToDelete == null) {
            request.setAttribute("errorMessage", EMPTY_DELETE_USER);
            request.getRequestDispatcher(UrlUtils.getCommandUrl(CommandEnum.SHOW_ERROR_PAGE.name())).forward(request, response);
            return;
        }

        if (
                userLoginToDelete.equals(currentUser.getLogin())
                        || ((currentUser.getRole() == Roles.ADMINISTRATOR) && (userToDelete.getRole() != Roles.ADMINISTRATOR))
        ) {
            daoFactory.getUserDAO().delete(userLoginToDelete);
            String previousPageCommand = request.getParameter("previousPage");
            response.sendRedirect(UrlUtils.getCommandUrl(previousPageCommand));

        } else {
            request.setAttribute("errorMessage", CANT_DELETE);
            request.getRequestDispatcher(UrlUtils.getCommandUrl(CommandEnum.SHOW_ERROR_PAGE.name())).forward(request, response);
        }
    }
}

