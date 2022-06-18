package ru.rsreu.sciencecompetition.web.commands.guest;

import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.commands.Command;
import ru.rsreu.sciencecompetition.web.validators.NormalValidationResultable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowRegistrationPageCommand implements Command {
    private static final String ATTRIBUTE_NAME_LOGIN_VALIDATE_RESULT = "login_validation";
    private static final String ATTRIBUTE_NAME_PASSWORD_VALIDATE_RESULT = "password_validation";
    private static final String ATTRIBUTE_NAME_NAME_VALIDATE_RESULT = "name_validation";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_NAME_LOGIN_VALIDATE_RESULT, new NormalValidationResultable());
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_NAME_NAME_VALIDATE_RESULT, new NormalValidationResultable());
        setBaseValueAttributeIfNotExist(request, ATTRIBUTE_NAME_PASSWORD_VALIDATE_RESULT, new NormalValidationResultable());
        request.getRequestDispatcher(ConfigurationManagers.WEB_MANAGER.getProperty("page.register")).forward(request, response);
    }

    private void setBaseValueAttributeIfNotExist(HttpServletRequest request, String attributeKey, Object defaultValue) {
        if (request.getAttribute(attributeKey) == null) {
            request.setAttribute(attributeKey, defaultValue);
        }
    }
}
