package ru.rsreu.sciencecompetition.web.servlets;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dao.DBType;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManager;
import ru.rsreu.sciencecompetition.web.commands.CommandsFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FrontController, servlet, that handle all requests
 */
public class FrontController extends HttpServlet {
    /**
     * dao factory attribute
     */
    public static final String DAO_FACTORY_CONTEXT_ATTRIBUTE = "dao_factory_attribute";

    /**
     * init servlet method
     * @throws ServletException servlet exception
     */
    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute(DAO_FACTORY_CONTEXT_ATTRIBUTE, DBType.getTypeByName(ConfigurationManager.getProperty("dbtype")).getDAOFactory());
    }

    /**
     * handle get requests
     * @param req request
     * @param resp response
     * @throws ServletException servlet exception
     * @throws IOException i/o exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    /**
     * handle post requests
     * @param req request
     * @param resp response
     * @throws ServletException servlet exception
     * @throws IOException i/o exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    /**
     * handling all requests
     * @param request request
     * @param response response
     * @throws ServletException servlet exception
     * @throws IOException i/o exception
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandsFactory commandsFactory = new CommandsFactory();
        commandsFactory.defineCommand(request).execute(request, response);
    }

    /**
     * destroy servlet method
     */
    @Override
    public void destroy() {
        DAOFactory daoFactory = (DAOFactory)
                getServletContext()
                        .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);
        daoFactory.getUserDAO().setDefaultSessionsCount();
        super.destroy();
    }
}
