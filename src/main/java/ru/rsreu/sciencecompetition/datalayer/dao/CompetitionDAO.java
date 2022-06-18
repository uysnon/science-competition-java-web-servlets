package ru.rsreu.sciencecompetition.datalayer.dao;

import ru.rsreu.sciencecompetition.datalayer.dto.Competition;
import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionResultable;

import java.time.Instant;
import java.util.List;

/**
 * Coompetition dao
 */
public interface CompetitionDAO {
    /**
     * add competition
     * @param task task
     * @param competitionResultable strategy
     * @param endRegistrationDate end registration date
     * @param endSendingAnswerDate end sending answer date
     * @param expertIds expertIds
     */
    void add(String task, CompetitionResultable competitionResultable, Instant endRegistrationDate, Instant endSendingAnswerDate, List<Integer> expertIds);

    /**
     * get all
     * @return all competitions
     */
    List<Competition> getAll();

    /**
     * get by id
     * @param id id
     * @return competition with id = @id
     */
    Competition getById(int id);
}
