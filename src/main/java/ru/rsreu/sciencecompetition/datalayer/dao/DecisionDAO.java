package ru.rsreu.sciencecompetition.datalayer.dao;

import ru.rsreu.sciencecompetition.datalayer.dto.Decision;
import ru.rsreu.sciencecompetition.datalayer.dto.Marks;

import java.util.List;

/**
 * Decision dao
 */
public interface DecisionDAO {
    /**
     * make decision
     * @param expertId expert id
     * @param competitionParticipationId competition participation id
     * @param mark mark
     * @param comment comment
     */
    void makeDecision(int expertId, int competitionParticipationId, Marks mark, String comment);

    /**
     * get all
     * @return all decisions
     */
    List<Decision> getAll();

    /**
     * get by id
     * @param id id
     * @return decision with id = @id
     */
    Decision get(int id);

    /**
     * get expert decisions
     * @param expertId expert id
     * @return decisions, that makes expert with id = @id
     */
    List<Decision> getExpertDecisions(int expertId);

    /**
     * get decisions by competition id
     * @param competitionId competition id
     * @return get decisions, that have made to the competition with id = @id
     */
    List<Decision> getDecisionsByCompetitionId(int competitionId);

    /**
     * get decisions by competition participation id
     * @param competitionParticipationId competition participation id
     * @return decisionns, that have made to competition participation with id = @id
     */
    List<Decision> getDecisionsByCompetitionParticipationId(int competitionParticipationId);

    /**
     * is decision made by expert to competition participation
     * @param expertId expert id
     * @param participationId competition participation id
     * @return @{@code true} if decision have made
     */
    boolean isDecisionMade(int expertId, int participationId);
}
