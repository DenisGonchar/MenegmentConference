package menegment.conference.db.dao;

import java.sql.SQLException;
import java.util.List;

import manegment.conference.entity.User;

public interface UserDao {
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException;
	public User checkUser(User user) throws ClassNotFoundException, SQLException;
	public void addUser(User user) throws ClassNotFoundException, SQLException;
	public void removeUser(User user) throws ClassNotFoundException, SQLException;
	public boolean checkLoginEmail(String login, String email) throws SQLException, ClassNotFoundException;
	List<User> getAllSpeakers() throws ClassNotFoundException, SQLException;
	public User getUserByLogin(String login) throws SQLException, ClassNotFoundException;
	public void setRolle(User user, String rolle) throws SQLException, ClassNotFoundException;
}
