package ru.rsreu.sciencecompetition.web.commands.participant;

import ru.rsreu.sciencecompetition.datalayer.dao.DAOFactory;
import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionParticipation;
import ru.rsreu.sciencecompetition.web.servlets.FrontController;
import ru.rsreu.sciencecompetition.web.commands.Command;
import ru.rsreu.sciencecompetition.web.commands.CommandEnum;
import ru.rsreu.sciencecompetition.web.commands.UrlUtils;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;
import ru.rsreu.sciencecompetition.web.validators.Validator;
import ru.rsreu.sciencecompetition.web.validators.competition.answer.AnswerValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendAnswerCommand implements Command {
    private static final String COMPETITION_PARTICIPATION_ID_PARAM = "id";
    private static final String COMPETITION_PARTICIPATION_ANSWER_PARAM = "answer";
    private static final String ANSWER_VALIDATION_RESULT_ATTRIBUTE = "answer_validation";

    private Validator<String> answerValidator;

    public SendAnswerCommand() {
        answerValidator = new AnswerValidator();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = (DAOFactory) request
                .getServletContext()
                .getAttribute(FrontController.DAO_FACTORY_CONTEXT_ATTRIBUTE);
        int competitionParticipationId = Integer.parseInt(request.getParameter(COMPETITION_PARTICIPATION_ID_PARAM));

        CompetitionParticipation competitionParticipation = daoFactory.getCompetitionParticipationDAO().get(competitionParticipationId);
        String oldAnswer = competitionParticipation.getAnswer();
        if (oldAnswer != null) {
            String url = UrlUtils.getCommandUrl(CommandEnum.SHOW_COMPETITION_PARTICIPATION_ID.name().toLowerCase());
            url = String.format("%s&id=%d&message=you have already sent an answer", url, competitionParticipationId);
            response.sendRedirect((url));
            return;
        }
        String answer = request.getParameter(COMPETITION_PARTICIPATION_ANSWER_PARAM);
        ValidationResultable answerValidationResult = answerValidator.validate(answer);
        if (answerValidationResult.getValidationClass().isNormal()) {
            daoFactory.getCompetitionParticipationDAO().makeAnswer(competitionParticipationId, answer.trim());
            String url = UrlUtils.getCommandUrl(CommandEnum.SHOW_COMPETITION_PARTICIPATION_ID.name().toLowerCase());
            url = String.format("%s&id=%d", url, competitionParticipationId);
            response.sendRedirect(url);
        } else {
            request.setAttribute(ANSWER_VALIDATION_RESULT_ATTRIBUTE, answerValidationResult);
            request.setAttribute(COMPETITION_PARTICIPATION_ID_PARAM, competitionParticipationId);
            request.setAttribute(COMPETITION_PARTICIPATION_ANSWER_PARAM, answer);
            new ShowCompetitionParticipationById().execute(request, response);
        }
    }
}
