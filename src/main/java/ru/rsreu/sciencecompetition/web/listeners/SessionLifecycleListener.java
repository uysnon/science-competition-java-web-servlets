package ru.rsreu.sciencecompetition.web.listeners;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dao.DBType;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManager;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLifecycleListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        int userId = (Integer) httpSessionEvent.getSession().getAttribute(
                ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.id")
        );
        DAOFactory daoFactory = DBType.getTypeByName(ConfigurationManager.getProperty("dbtype")).getDAOFactory();
        daoFactory.getUserDAO().decrementSessionsCount(userId);
    }
}
