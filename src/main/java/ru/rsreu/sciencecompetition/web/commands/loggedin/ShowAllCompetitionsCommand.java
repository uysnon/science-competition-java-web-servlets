package ru.rsreu.sciencecompetition.web.commands.loggedin;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.Competition;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.Command;
import ru.rsreu.sciencecompetition.web.viewclasses.CompetitionView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShowAllCompetitionsCommand implements Command {
    public static String COMPETITIONS_ATTRIBUTE = "competitions_v";

    public ShowAllCompetitionsCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        List<Competition> competitions = daoFactory.getCompetitionDAO().getAll();
        competitions.sort(Comparator.comparing(Competition::getEndRegistrationDate).reversed());
        List<CompetitionView> competitionViews = competitions.stream().map(CompetitionView::createFrom).collect(Collectors.toList());
        request.setAttribute(COMPETITIONS_ATTRIBUTE, competitionViews);
        request.getRequestDispatcher(ConfigurationManagers.WEB_MANAGER.getProperty("page.allCompetitions")).forward(request,response);

    }
}
