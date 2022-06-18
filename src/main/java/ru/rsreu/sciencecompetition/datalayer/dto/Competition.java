package ru.rsreu.sciencecompetition.datalayer.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Competition
 */
public class Competition {
    /**
     * id
     */
    private int id;
    /**
     * evaluation strategy
     */
    private CompetitionResultable evaluationStrategy;
    /**
     * task
     */
    private String task;
    /**
     * end registration date
     */
    private Instant endRegistrationDate;
    /**
     * end sending answers date
     */
    private Instant endSendingAnswerDate;
    /**
     * experts
     */
    private List<User> experts;

    /**
     * default constructor
     */
    public Competition() {
        experts = new ArrayList<>();
    }

    /**
     * all field constructor
     * @param id id
     * @param evaluationStrategy evaluation strategy
     * @param task task
     * @param endRegistrationDate end registration date
     * @param endSendingAnswerDate end sending answers date
     * @param experts experts
     */
    public Competition(int id, CompetitionResultable evaluationStrategy, String task, Instant endRegistrationDate, Instant endSendingAnswerDate, List<User> experts) {
        this.id = id;
        this.evaluationStrategy = evaluationStrategy;
        this.task = task;
        this.endRegistrationDate = endRegistrationDate;
        this.endSendingAnswerDate = endSendingAnswerDate;
        this.experts = experts;
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
     * get evaluation strategy
     * @return evaluation strategy
     */
    public CompetitionResultable getEvaluationStrategy() {
        return evaluationStrategy;
    }

    /**
     * set evaluation strategy
     * @param evaluationStrategy evaluation strategy
     */
    public void setEvaluationStrategy(CompetitionResultable evaluationStrategy) {
        this.evaluationStrategy = evaluationStrategy;
    }

    /**
     * get task
     * @return task
     */
    public String getTask() {
        return task;
    }

    /**
     * set task
     * @param task task
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * get end registration date
     * @return end registration date
     */
    public Instant getEndRegistrationDate() {
        return endRegistrationDate;
    }

    /**
     * set end registration date
     * @param endRegistrationDate end registration date
     */
    public void setEndRegistrationDate(Instant endRegistrationDate) {
        this.endRegistrationDate = endRegistrationDate;
    }

    /**
     * get end sending answers date
     * @return end sending answer date
     */
    public Instant getEndSendingAnswerDate() {
        return endSendingAnswerDate;
    }

    /**
     * set end sending answers date
     * @param endSendingAnswerDate end sending answers date
     */
    public void setEndSendingAnswerDate(Instant endSendingAnswerDate) {
        this.endSendingAnswerDate = endSendingAnswerDate;
    }

    /**
     * get experts
     * @return experts
     */
    public List<User> getExperts() {
        return experts;
    }

    /**
     * set experts
     * @param experts experts
     */
    public void setExperts(List<User> experts) {
        this.experts = experts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competition)) return false;
        Competition that = (Competition) o;
        return id == that.id &&
                evaluationStrategy == that.evaluationStrategy &&
                Objects.equals(task, that.task) &&
                Objects.equals(endRegistrationDate, that.endRegistrationDate) &&
                Objects.equals(endSendingAnswerDate, that.endSendingAnswerDate) &&
                Objects.equals(experts, that.experts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, evaluationStrategy, task, endRegistrationDate, endSendingAnswerDate, experts);
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", evaluationStrategy=" + evaluationStrategy +
                ", task='" + task + '\'' +
                ", endRegistrationDate=" + endRegistrationDate +
                ", endSendingAnswerDate=" + endSendingAnswerDate +
                ", experts=" + experts +
                '}';
    }
}
