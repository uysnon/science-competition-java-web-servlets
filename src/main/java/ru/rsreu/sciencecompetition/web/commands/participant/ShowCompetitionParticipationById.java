package ru.rsreu.sciencecompetition.web.commands.participant;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionParticipation;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;

import javax.servlet.http.HttpServletRequest;

public class ShowCompetitionParticipationById extends ShowCompetitionParticipation {
    private static final String COMPETITION_PARTICIPATION_ID_PARAM = "id";
    @Override
    public CompetitionParticipation getCompetitionParticipation(HttpServletRequest request) {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);

        int id = Integer.parseInt(request.getParameter(COMPETITION_PARTICIPATION_ID_PARAM));
        CompetitionParticipation competitionParticipation = daoFactory.getCompetitionParticipationDAO().get(id);

        return competitionParticipation;
    }
}
