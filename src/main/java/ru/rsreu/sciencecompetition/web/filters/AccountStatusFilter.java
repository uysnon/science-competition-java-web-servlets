package ru.rsreu.sciencecompetition.web.filters;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.Statuses;
import ru.rsreu.sciencecompetition.datalayer.dto.User;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.UrlUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountStatusFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        DAOFactory daoFactory = (DAOFactory) servletRequest
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        boolean goNext = true;
        String login = (String) httpServletRequest.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.login"));
        if (login != null) {
            User user = daoFactory.getUserDAO().get(login);
            if (user.getStatus() != Statuses.ACTIVE) {
                goNext = false;
                httpServletRequest.getRequestDispatcher(UrlUtils.getCommandUrl("logout")).forward(httpServletRequest, httpServletResponse);
            }
        }
        if (goNext) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
