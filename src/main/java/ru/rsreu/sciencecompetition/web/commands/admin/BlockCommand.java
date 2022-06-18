package ru.rsreu.sciencecompetition.web.commands.admin;

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

public class BlockCommand implements Command {
    private static final String NO_SUCH_ROLE = "Недостаточно прав пользователя для блокировки";
    private static final String CANT_BLOCK = "Выбранный пользователь не существует или является администратором";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        User currentUser = daoFactory.getUserDAO().get((String) request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.login")));
        if (currentUser == null || currentUser.getRole() != Roles.ADMINISTRATOR){
            request.setAttribute("errorMessage", NO_SUCH_ROLE);
            request.getRequestDispatcher(UrlUtils.getCommandUrl(CommandEnum.SHOW_ERROR_PAGE.name())).forward(request,response);
            return;
        }
        String userLoginToBlock = request.getParameter("user_login");
        User userToBlock = daoFactory.getUserDAO().get(userLoginToBlock);

        if (userToBlock == null || userToBlock.getRole() == Roles.ADMINISTRATOR){
            request.setAttribute("errorMessage", CANT_BLOCK);
            request.getRequestDispatcher(UrlUtils.getCommandUrl(CommandEnum.SHOW_ERROR_PAGE.name())).forward(request, response);
            return;
        }

        daoFactory.getUserDAO().block(userLoginToBlock);

        String previousPageCommand = request.getParameter("previousPage");
        response.sendRedirect(UrlUtils.getCommandUrl(previousPageCommand));
    }
}
