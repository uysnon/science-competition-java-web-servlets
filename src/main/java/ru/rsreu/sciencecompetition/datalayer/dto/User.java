package ru.rsreu.sciencecompetition.datalayer.dto;

import java.util.Objects;

/**
 * User
 */
public class User {
    /**
     * user id
     */
    private int id;
    /**
     * login
     */
    private String login;
    /**
     * password
     */
    private String password;
    /**
     * name
     */
    private String name;
    /**
     * role
     */
    private Roles role;
    /**
     * status
     */
    private Statuses status;
    /**
     * count of sessions, need to get online user status
     */
    private int sessionsCount;

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * all fields constructor
     * @param id id
     * @param login login
     * @param password password
     * @param name name
     * @param role role
     * @param status status
     * @param sessionsCount sessionsCount
     */
    public User(int id, String login, String password, String name, Roles role, Statuses status, int sessionsCount) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.status = status;
        this.sessionsCount = sessionsCount;
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
     * get login
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * set login
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get role
     * @return role
     */
    public Roles getRole() {
        return role;
    }

    /**
     * set role
     * @param role role
     */
    public void setRole(Roles role) {
        this.role = role;
    }

    /**
     * get status
     * @return status
     */
    public Statuses getStatus() {
        return status;
    }

    /**
     * set status
     * @param status status
     */
    public void setStatus(Statuses status) {
        this.status = status;
    }

    /**
     * get sessions count
     * @return sessions count
     */
    public int getSessionsCount() {
        return sessionsCount;
    }

    /**
     * set sessions count
     * @param sessionsCount sessions count
     */
    public void setSessionsCount(int sessionsCount) {
        this.sessionsCount = sessionsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                sessionsCount == user.sessionsCount &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                role == user.role &&
                status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, role, status, sessionsCount);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", sessionsCount=" + sessionsCount +
                '}';
    }
}
