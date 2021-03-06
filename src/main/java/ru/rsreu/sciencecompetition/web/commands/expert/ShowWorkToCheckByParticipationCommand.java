package ru.rsreu.sciencecompetition.web.commands.expert;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.Decision;
import ru.rsreu.sciencecompetition.resources.utils.ConfigurationManagers;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.viewclasses.CompetitionForExpertView;

import javax.servlet.http.HttpServletRequest;

public class ShowWorkToCheckByParticipationCommand extends ShowWorkToCheckCommand {
    private static final String COMPETITION_PARTICIPATION_ID_PARAM = "id";


    @Override
    public CompetitionForExpertView getCompetitionView(HttpServletRequest request) {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        int participationId = Integer.parseInt(request.getParameter(COMPETITION_PARTICIPATION_ID_PARAM));
        int userId = (Integer) request.getSession().getAttribute(ConfigurationManagers.WEB_MANAGER.getProperty("session.attribute.id"));

        boolean isDecisionMade = daoFactory.getDecisionDAO().isDecisionMade(userId, participationId);
        if (isDecisionMade) {
            Decision decision =
                    daoFactory.getDecisionDAO()
                            .getDecisionsByCompetitionParticipationId(participationId)
                            .stream()
                            .filter(decisionInner -> decisionInner.getExpert().getId() == userId)
                            .findAny()
                            .orElse(null);
            return CompetitionForExpertView.createOf(decision);
        } else {
            return CompetitionForExpertView.createOf(
                    daoFactory.getCompetitionParticipationDAO().get(participationId)
            );
        }
    }
}
