package ru.rsreu.sciencecompetition.web.commands.expert;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.viewclasses.CompetitionForExpertView;

import javax.servlet.http.HttpServletRequest;

public class ShowWorkToCheckByDecisionCommand extends ShowWorkToCheckCommand {
    private static final String DECISION_ID_PARAM = "id";

    @Override
    public CompetitionForExpertView getCompetitionView(HttpServletRequest request) {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        int decisionId = Integer.parseInt(request.getParameter(DECISION_ID_PARAM));

        return CompetitionForExpertView.createOf(
                daoFactory.getDecisionDAO().get(decisionId)
        );
    }
}
