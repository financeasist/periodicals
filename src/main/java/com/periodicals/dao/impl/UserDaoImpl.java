package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.periodicals.dao.UserDao;
import com.periodicals.models.User;
import com.periodicals.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	final static String CREATE_USER = "insert into user (`email`,`password`,`firstName`,`lastName`,`role`,`isbanned`)values(?,?,?,?,?,?);";
	final static String GET_USER_BYID = "select * from user where id=?;";
	final static String GET_USER_BYEMAIL = "select * from user where email=?;";
	final static String GET_ALL_USERS = "select * from user; ";
	final static String UPDATE_USER_BYID = " update user set email =?, password = ?,role=?, isbanned=? where id=?; ";
	final static String UPDATE_EMAILANDPASSWORD_BYID = " update user set email =?, password = ? where id=?; ";
	final static String UPDATE_FIRSTNAME_BYEMAIL = " update user set firstName=? where email=?; ";
	final static String UPDATE_LASTNAME_BYEMAIL = " update user set lastName=? where email=?; ";
	final static String UPDATE_ROLE_BYEMAIL = " update user set role=? where email=?; ";
	final static String UPDATE_ISBANED_BYEMAIL = " update user set isbanned=? where email=?; ";
	final static String DELETE_BYEMAIL = " delete  from user where email=?;";
	final static String GET_USERID_BYEMAIL = " select id  from user where email=?;";
	final static String UPDATE_USER_BYEMAIL = " update user set password = ?,role=?, isbanned=? where email=?; ";

	public UserDaoImpl() {
	}

	public void create(User t) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
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
			System.out.println("User : " + "email= " + "'" + t.getEmail() + "'" + ", firstName= " + "'"
					+ t.getFirstName() + "'" + ", lastName= " + "'" + t.getLastName() + "'" + ", role= " + "'"
					+ t.getRole().toString() + "'" + ", isBanned= " + "'" + t.getIsBaned() + "' created!.");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public User getByID(int id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USER_BYID);
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
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}

	public User getByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USER_BYEMAIL);
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
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> getAll() {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
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
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public void updateAllFieldsUserByID(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_USER_BYID);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRoleString());
			statement.setBoolean(4, user.getIsBaned());
			statement.setInt(5, id);
			statement.executeUpdate();
			System.out.println("users (id= " + "'" + id + "') fields was change! :" + "new email= '" + user.getEmail()
					+ "'," + "new password= '" + user.getPassword() + "'," + " new role= '" + user.getRole() + "', "
					+ "new isBaned= '" + user.getIsBaned() + "' ;");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateEmailANDPasswordByID(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_EMAILANDPASSWORD_BYID);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setInt(3, id);
			statement.executeUpdate();
			System.out.println("users (id= " + "'" + id + "') email and password was change! on:" + "new email= '"
					+ user.getEmail() + "'," + "new password= '" + user.getPassword() + "';");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateFirstNameByEmail(String firstName, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_FIRSTNAME_BYEMAIL);
			statement.setString(1, firstName);
			statement.setString(2, email);

			statement.executeUpdate();
			System.out.println("users (with email= '" + email + "') firstName was change on: '" + firstName + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateLastNameByEmail(String lastName, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_LASTNAME_BYEMAIL);
			statement.setString(1, lastName);

			statement.setString(2, email);

			statement.executeUpdate();
			System.out.println("users (with email= '" + email + "') lastName was change on: '" + lastName + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateRoleByEmail(String role, String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_ROLE_BYEMAIL);
			statement.setString(1, role);
			statement.setString(2, email);

			statement.executeUpdate();
			System.out.println("users (with email= " + "'" + email + "') role was change on '" + role + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void updateIsBannedByEmail(Boolean isBaned, String email) {

		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_ISBANED_BYEMAIL);
			statement.setBoolean(1, isBaned);
			statement.setString(2, email);

			statement.executeUpdate();
			System.out.println("users (email= " + "'" + email + "') flag 'IsBanned' was change on '" + isBaned + "'! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void delete(User user) {

		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " delete  from user where email=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());

			statement.executeUpdate();
			System.out.println("User :'" + user.getEmail() + "', '" + user.getFirstName() + "', '" + user.getLastName()
					+ "', role: '" + user.getRoleString() + "', isBaned: '" + user.getIsBaned() + "' was deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void deleteByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_BYEMAIL);
			statement.setString(1, email);

			statement.executeUpdate();
			System.out.println("User with email= '" + email + "' was deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public Integer getIdByEmail(String email) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_USERID_BYEMAIL);
			statement.setString(1, email);
			
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			user.setId(resSet.getInt("id"));
			user.setEmail(email);
			System.out.println("User with email= '" + user.getEmail() + "' has id= '" + user.getId() + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user.getId();

	}

	public void updateByOnefield(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_USER_BYEMAIL);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getRoleString());
			statement.setBoolean(3, user.getIsBaned());
			statement.setString(4, user.getEmail());
			statement.executeUpdate();
			System.out.println("users (Email: '" + user.getEmail() + "') fields was change! :" + "new email= '"
					+ user.getEmail() + "'," + "new password= '" + user.getPassword() + "'," + " new role= '"
					+ user.getRole() + "', " + "new isBaned= '" + user.getIsBaned() + "' ;");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally

		{
			try {
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	

	

	

	

	

	

}
