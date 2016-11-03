package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.periodicals.dao.UserDao;
import com.periodicals.models.User;
import com.periodicals.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	private final static Logger logger = Logger.getLogger(UserDaoImpl.class); 
	final static String CREATE_USER = "insert into user (`email`,`password`,`firstName`,`lastName`,`role`,`isbanned`)values(?,?,?,?,?,?);";
	final static String GET_USER_BY_ID = "select * from user where id=?;";
	final static String GET_USER_BY_EMAIL = "select * from user where email=?;";
	final static String GET_ALL_USERS = "select * from user; ";
	final static String UPDATE_USER_BY_ID = " update user set email =?, password = ?,role=?, isbanned=? where id=?; ";
	final static String UPDATE_EMAIL_AND_PASSWORD_BY_ID = " update user set email =?, password = ? where id=?; ";
	final static String UPDATE_FIRSTNAME_BY_EMAIL = " update user set firstName=? where email=?; ";
	final static String UPDATE_LASTNAME_BY_EMAIL = " update user set lastName=? where email=?; ";
	final static String UPDATE_ROLE_BY_EMAIL = " update user set role=? where email=?; ";
	final static String UPDATE_ISBANED_BY_EMAIL = " update user set isbanned=? where email=?; ";
	final static String DELETE_BY_EMAIL = " delete  from user where email=?;";
	final static String GET_USER_ID_BY_EMAIL = " select id  from user where email=?;";
	final static String UPDATE_USER_BY_EMAIL = " update user set password = ?,role=?, isbanned=? where email=?; ";

	
	public void create(User t) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(CREATE_USER);
			statement.setString(1, t.getEmail());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getFirstName());
			statement.setString(4, t.getLastName());
			statement.setString(5, t.getRoleString());
			statement.setBoolean(6, t.getIsBaned());
			statement.execute();
			logger.info("User : " + "email= " + "'" + t.getEmail() + "'" + ", firstName= " + "'"
					+ t.getFirstName() + "'" + ", lastName= " + "'" + t.getLastName() + "'" + ", role= " + "'"
					+ t.getRole().toString() + "'" + ", isBanned= " + "'" + t.getIsBaned() + "' created!.");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public User getById(int id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USER_BY_ID);
			statement.setInt(1, id);
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			user.setId(resSet.getInt("id"));
			user.setEmail(resSet.getString("email"));
			user.setPassword(resSet.getString("password"));
			user.setFirstName(resSet.getString("firstName"));
			user.setLastName(resSet.getString("lastName"));
			user.setRole(resSet.getString("role"));
			user.setIsBaned(resSet.getBoolean("isbanned"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}

	public User getUserByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USER_BY_EMAIL);
			statement.setString(1, email);
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			user.setId(resSet.getInt("id"));
			user.setEmail(resSet.getString("email"));
			user.setPassword(resSet.getString("password"));
			user.setFirstName(resSet.getString("firstName"));
			user.setLastName(resSet.getString("lastName"));
			user.setRole(resSet.getString("role"));
			user.setIsBaned(resSet.getBoolean("isbanned"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> getAll() {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		List<User> list = new ArrayList<User>();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_ALL_USERS);
			ResultSet resSet = statement.executeQuery();
			while (resSet.next()) {
				User user = new User();
				user.setId(resSet.getInt("id"));
				user.setEmail(resSet.getString("email"));
				user.setPassword(resSet.getString("password"));
				user.setFirstName(resSet.getString("firstName"));
				user.setLastName(resSet.getString("lastName"));
				user.setRole(resSet.getString("role"));
				user.setIsBaned(resSet.getBoolean("isbanned"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public void updateAllFieldsUserById(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_USER_BY_ID);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRoleString());
			statement.setBoolean(4, user.getIsBaned());
			statement.setInt(5, id);
			statement.executeUpdate();
			logger.info("users (id= " + "'" + id + "') fields was change! :" + "new email= '" + user.getEmail()
					+ "'," + "new password= '" + user.getPassword() + "'," + " new role= '" + user.getRole() + "', "
					+ "new isBaned= '" + user.getIsBaned() + "' ;");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateEmailAndPasswordById(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_EMAIL_AND_PASSWORD_BY_ID);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setInt(3, id);
			statement.executeUpdate();
			logger.info("users (id= " + "'" + id + "') email and password was change! on:" + "new email= '"
					+ user.getEmail() + "'," + "new password= '" + user.getPassword() + "';");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateFirstNameByEmail(String firstName, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_FIRSTNAME_BY_EMAIL);
			statement.setString(1, firstName);
			statement.setString(2, email);

			statement.executeUpdate();
			logger.info("users (with email= '" + email + "') firstName was change on: '" + firstName + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateLastNameByEmail(String lastName, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_LASTNAME_BY_EMAIL);
			statement.setString(1, lastName);

			statement.setString(2, email);

			statement.executeUpdate();
			logger.info("users (with email= '" + email + "') lastName was change on: '" + lastName + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateRoleByEmail(String role, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_ROLE_BY_EMAIL);
			statement.setString(1, role);
			statement.setString(2, email);

			statement.executeUpdate();
			logger.info("users (with email= " + "'" + email + "') role was change on '" + role + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateIsBannedByEmail(Boolean isBaned, String email) {

		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_ISBANED_BY_EMAIL);
			statement.setBoolean(1, isBaned);
			statement.setString(2, email);

			statement.executeUpdate();
			logger.info("users (email= " + "'" + email + "') flag 'IsBanned' was change on '" + isBaned + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void delete(User user) {

		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " delete  from user where email=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());

			statement.executeUpdate();
			logger.info("User :'" + user.getEmail() + "', '" + user.getFirstName() + "', '" + user.getLastName()
					+ "', role: '" + user.getRoleString() + "', isBaned: '" + user.getIsBaned() + "' was deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void deleteByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_BY_EMAIL);
			statement.setString(1, email);

			statement.executeUpdate();
			logger.info("User with email= '" + email + "' was deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public Integer getIdByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USER_ID_BY_EMAIL);
			statement.setString(1, email);
			
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			user.setId(resSet.getInt("id"));
			user.setEmail(email);
			logger.info("User with email= '" + user.getEmail() + "' has id= '" + user.getId() + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user.getId();

	}

	public void updateByOneField(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_USER_BY_EMAIL);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getRoleString());
			statement.setBoolean(3, user.getIsBaned());
			statement.setString(4, user.getEmail());
			statement.executeUpdate();
			logger.info("users (Email: '" + user.getEmail() + "') fields was change! :" + "new email= '"
					+ user.getEmail() + "'," + "new password= '" + user.getPassword() + "'," + " new role= '"
					+ user.getRole() + "', " + "new isBaned= '" + user.getIsBaned() + "' ;");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				logger.info("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	

	

	

	

	

	

}
