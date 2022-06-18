package ru.rsreu.sciencecompetition.datalayer.dto;

import java.util.Objects;

/**
 * Expert's decision
 */
public class Decision {
    /**
     * id
     */
    private int id;
    /**
     * mark
     */
    private Marks mark;
    /**
     * expert
     */
    private User expert;
    /**
     * competitionParticipation
     */
    private CompetitionParticipation competitionParticipation;
    /**
     * comment
     */
    private String comment;

    /**
     * default constructor
     */
    public Decision() {
    }

    /**
     * all fields constructor
     * @param id id
     * @param mark mark
     * @param expert expert
     * @param competitionParticipation competitionParticipation
     * @param comment comment
     */
    public Decision(int id, Marks mark, User expert, CompetitionParticipation competitionParticipation, String comment) {
        this.id = id;
        this.mark = mark;
        this.expert = expert;
        this.competitionParticipation = competitionParticipation;
        this.comment = comment;
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
     * get expert
     * @return expert
     */
    public User getExpert() {
        return expert;
    }

    /**
     * set expert
     * @param expert expert
     */
    public void setExpert(User expert) {
        this.expert = expert;
    }

    /**
     * get competition participation
     * @return competition participation
     */
    public CompetitionParticipation getCompetitionParticipation() {
        return competitionParticipation;
    }

    /**
     * set competition participation
     * @param competitionParticipation competition participation
     */
    public void setCompetitionParticipation(CompetitionParticipation competitionParticipation) {
        this.competitionParticipation = competitionParticipation;
    }

    /**
     * get comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * set comment
     * @param comment comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decision)) return false;
        Decision decision = (Decision) o;
        return id == decision.id &&
                mark == decision.mark &&
                Objects.equals(expert, decision.expert) &&
                Objects.equals(competitionParticipation, decision.competitionParticipation) &&
                Objects.equals(comment, decision.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, expert, competitionParticipation, comment);
    }

    @Override
    public String toString() {
        return "Decision{" +
                "id=" + id +
                ", mark=" + mark +
                ", expert=" + expert +
                ", competitionParticipation=" + competitionParticipation +
                ", comment='" + comment + '\'' +
                '}';
    }
}
