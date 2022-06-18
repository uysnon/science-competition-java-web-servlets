package ru.rsreu.sciencecompetition.datalayer.dao;

import ru.rsreu.sciencecompetition.datalayer.dto.Roles;
import ru.rsreu.sciencecompetition.datalayer.dto.Statuses;
import ru.rsreu.sciencecompetition.datalayer.dto.User;

import java.util.List;

/**
 * user dao
 */
public interface UserDAO {
	/**
	 * block user
	 * @param login user login to block
	 */
	void block(String login);

	/**
	 * unblock user
	 * @param login user login to unblock
	 */
	void unblock(String login);

	/**
	 * delete user
	 * @param login login user to delete
	 */
	void delete(String login);

	/**
	 * get all users
	 * @return users
	 */
	List<User> getAll();

	/**
	 * get users with role
	 * @param role role
	 * @return users with role = @role
	 */
	List<User> getAllByRole(Roles role);

	/**
	 * get users with status
	 * @param status status
	 * @return users with status = @status
	 */
	List<User> getAllByStatus(Statuses status);

	/**
	 * get user by id
	 * @param id id
	 * @return user with id = @id
	 */
	User get(int id);

	/**
	 * get user by login
	 * @param login login
	 * @return user with login = @login
	 */
	User get(String login);

	/**
	 * authenticate user
	 * @param login user login
	 * @param password user password
	 * @return  authentication result
	 */
	AuthenticationResults authenticate(String login, String password);

	/**
	 * is login exists
	 * @param login login
	 * @return @{@code true} if login exists
	 */
	boolean isLoginExist(String login);

	/**
	 * create user
	 * @param login login
	 * @param password password
	 * @param name name
	 * @param role role
	 */
	void createUser(String login, String password, String name, Roles role);

	/**
	 * edit user
	 * @param userId user id
 	 * @param name new name
	 * @param password new password
	 */
    void editUser(int userId, String name, String password);

	/**
	 * increment sessions count
	 * @param userId user id
	 */
	void incrementSessionsCount(int userId);

	/**
	 * decrement sessions count
	 * @param userId user id
	 */
    void decrementSessionsCount(int userId);

	/**
	 * set default (0) sessions count to all users
	 */
	void setDefaultSessionsCount();
}
