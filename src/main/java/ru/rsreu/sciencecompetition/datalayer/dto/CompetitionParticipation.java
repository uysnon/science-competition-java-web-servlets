package ru.rsreu.sciencecompetition.datalayer.dto;

import java.util.Objects;

/**
 * Competition participation
 */
public class CompetitionParticipation {
    /**
     * id
     */
    private int id;
    /**
     * competition
     */
    private Competition competition;
    /**
     * participant
     */
    private User participant;
    /**
     * mark
     */
    private Marks mark;
    /**
     * answer
     */
    private String answer;

    /**
     * base constructor
     */
    public CompetitionParticipation() {
    }

    /**
     * all fields constructor
     * @param id id
     * @param competition competition
     * @param participant participant
     * @param mark mark
     * @param answer answer
     */
    public CompetitionParticipation(int id, Competition competition, User participant, Marks mark, String answer) {
        this.id = id;
        this.competition = competition;
        this.participant = participant;
        this.mark = mark;
        this.answer = answer;
    }

    /**
     * get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get competition
     * @return competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * set competition
     * @param competition competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    /**
     * get participant
     * @return participant
     */
    public User getParticipant() {
        return participant;
    }

    /**
     * set participant
     * @param participant participant
     */
    public void setParticipant(User participant) {
        this.participant = participant;
    }

    /**
     * get mark
     * @return mark
     */
    public Marks getMark() {
        return mark;
    }

    /**
     * set mark
     * @param mark mark
     */
    public void setMark(Marks mark) {
        this.mark = mark;
    }

    /**
     * get answer
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * set answer
     * @param answer answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetitionParticipation)) return false;
        CompetitionParticipation that = (CompetitionParticipation) o;
        return id == that.id &&
                Objects.equals(competition, that.competition) &&
                Objects.equals(participant, that.participant) &&
                mark == that.mark &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, competition, participant, mark, answer);
    }

    @Override
    public String toString() {
        return "CompetitionParticipation{" +
                "id=" + id +
                ", competition=" + competition +
                ", participant=" + participant +
                ", mark=" + mark +
                ", answer='" + answer + '\'' +
                '}';
    }
}
