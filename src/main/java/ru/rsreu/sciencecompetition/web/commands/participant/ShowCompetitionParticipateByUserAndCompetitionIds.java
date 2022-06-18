package ru.rsreu.sciencecompetition.web.commands.participant;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionParticipation;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;

import javax.servlet.http.HttpServletRequest;

public class ShowCompetitionParticipateByUserAndCompetitionIds extends ShowCompetitionParticipation {
    private static final String COMPETITION_ID_PARAM = "competitionId";
    private static final String USER_ID_PARAM = "userId";

    @Override
    public CompetitionParticipation getCompetitionParticipation(HttpServletRequest request) {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        int competitionId = Integer.parseInt(request.getParameter(COMPETITION_ID_PARAM));
        int userId = Integer.parseInt(request.getParameter(USER_ID_PARAM));
        CompetitionParticipation competitionParticipation = daoFactory.getCompetitionParticipationDAO().get(competitionId, userId);

        return competitionParticipation;
    }
}
