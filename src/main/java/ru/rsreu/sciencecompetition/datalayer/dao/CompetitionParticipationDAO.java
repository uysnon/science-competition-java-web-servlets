package ru.rsreu.sciencecompetition.datalayer.dao;

import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionParticipation;
import ru.rsreu.sciencecompetition.datalayer.dto.Marks;

import java.util.List;

/**
 * Competition participation dao
 */
public interface CompetitionParticipationDAO {
    /**
     * participate
     * @param competitionId competition id
     * @param participantId participant id
     */
    void participate(int competitionId, int participantId);

    /**
     * is participate
     * @param competitionId competition id
     * @param participantId participant id
     * @return @{@code true} if user participate in competition
     */
    boolean isParticipate(int competitionId, int participantId);

    /**
     * get by id
     * @param id id
     * @return competition participation with id = @id
     */
    CompetitionParticipation get(int id);

    /**
     * get by competition id and participant id
     * @param competitionId competition id
     * @param participantId participant id
     * @return competitin participation
     */
    CompetitionParticipation get(int competitionId, int participantId);

    /**
     * get verification required participations
     * @param expertId expert id
     * @return verification required participations
     */
    List<CompetitionParticipation> getVerificationRequiredParticipations(int expertId);

    /**
     * make answer
     * @param participationId competition participation id
     * @param answer answer
     */
    void makeAnswer(int participationId, String answer);

    /**
     * get by competition id
     * @param competitionId competition id
     * @return competition participations with competition id = @competitionId
     */
    List<CompetitionParticipation> getByCompetitionId(int competitionId);

    /**
     * get by participant id
     * @param participantId participant id
     * @return competition participations with participant id = @participantId
     */
    List<CompetitionParticipation> getByParticipantId(int participantId);
    void setMark(int participationId, Marks mark);
}
