package ru.rsreu.sciencecompetition.web.commands.loggedin;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.User;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.Command;
import ru.rsreu.sciencecompetition.web.validators.NormalValidationResultable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEditAccountByUserPageCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_ROLE = "role";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "password_repeat";

    private static final String ATTRIBUTE_ID = "id";

    private static final String ATTRIBUTE_NAME_PASSWORD_VALIDATE_RESULT = "password_validation";
    private static final String ATTRIBUTE_NAME_PASSWORD_REPEAT_VALIDATE_RESULT = "password_repeat_validation";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        int userId = (Integer) request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.id"));
        String login = (String) request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.login"));
        User user = daoFactory.getUserDAO().get(userId);
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_ID, userId);
        setBaseValueAttributeIfNotExist(request, PARAM_NAME_LOGIN, login);
        setBaseValueAttributeIfNotExist(request, PARAM_NAME_NAME, user.getName());
        setBaseValueAttributeIfNotExist(request, PARAM_NAME_ROLE, request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.role")));
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_NAME_PASSWORD_VALIDATE_RESULT, new NormalValidationResultable());
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_NAME_PASSWORD_REPEAT_VALIDATE_RESULT, new NormalValidationResultable());
        setBaseValueAttributeIfNotExist(request, PARAM_NAME_PASSWORD, user.getPassword());
        setBaseValueAttributeIfNotExist(request, PARAM_NAME_PASSWORD_REPEAT, user.getPassword());
        request.getRequestDispatcher(ConfigurationManagers.WEB_MANAGER.getProperty("page.loggedIn.editAccount")).forward(request, response);

    }

    private void setBaseValueAttributeIfNotExist(HttpServletRequest request, String attributeKey, Object defaultValue) {
        if (request.getAttribute(attributeKey) == null) {
            request.setAttribute(attributeKey, defaultValue);
        }
    }

}
