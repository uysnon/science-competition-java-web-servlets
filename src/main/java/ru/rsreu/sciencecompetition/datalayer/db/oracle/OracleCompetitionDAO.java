package ru.rsreu.sciencecompetition.datalayer.db.oracle;

import ru.rsreu.sciencecompetition.datalayer.dao.CompetitionDAO;
import ru.rsreu.sciencecompetition.datalayer.dto.Competition;
import ru.rsreu.sciencecompetition.datalayer.dto.CompetitionResultable;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OracleCompetitionDAO implements CompetitionDAO {
    private Connection connection;
    private OracleQueriesUtils oracleQueriesUtils;

    public OracleCompetitionDAO(Connection connection) {
        this.connection = connection;
        this.oracleQueriesUtils = new OracleQueriesUtils();
    }

    @Override
    public void add(String task, CompetitionResultable competitionResultable, Instant endRegistrationDate, Instant endSendingAnswerDate, List<Integer> expertIds) {
        try {
            int competitionId = oracleQueriesUtils.addCompetition(connection, task, StrategyAdapters.generateStrategySQL(competitionResultable), endRegistrationDate, endSendingAnswerDate);
            oracleQueriesUtils.addCompetitionEvaluation(connection, competitionId, expertIds);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Competition> getAll() {
        return new ArrayList<>(oracleQueriesUtils.getAllCompetitions(connection));
    }


    @Override
    public Competition getById(int id) {
        try {
            Competition competition = oracleQueriesUtils.getCompetitionById(connection, id);
            return competition;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
