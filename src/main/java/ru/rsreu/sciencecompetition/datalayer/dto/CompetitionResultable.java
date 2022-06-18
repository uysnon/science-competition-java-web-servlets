package ru.rsreu.sciencecompetition.datalayer.dto;

import java.util.List;

public interface CompetitionResultable {
    Marks calculateMark(List<Marks> allMarks);
}
