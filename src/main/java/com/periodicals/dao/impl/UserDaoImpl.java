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

	public UserDaoImpl() {
	}

	
	public void create(User t) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = "insert into user (`email`,`password`,`firstName`,`lastName`,`role`,`isbanned`)values(?,?,?,?,?,?);";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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
		String sql = "select * from user where id=?;";
		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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
		String sql = "select * from user where email=?;";
		User user = new User();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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
		String sql = "select * from user; ";
		List<User> list = new ArrayList<User>();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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

	
	public void update_AllFieldsUser_ByID(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set email =?, password = ?,role=?, isbanned=? where id=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);

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

	
	public void update_EmailANDPassword_ByID(User user, Integer id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set email =?, password = ? where id=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);

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

//	
//	public void update(User user) {
//		System.out.println(
//				"Do you really want to change all users in Data base on this one ??!! Thinking about it again ! and "
//						+ "choose another method with updateBy...()! ");
//
//	}

	
	public void update_firstName_ByEmail(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set firstName=? where email=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getEmail());

			statement.executeUpdate();
			System.out.println("users (with email= '" + user.getEmail() + "') firstName was change on: '"
					+ user.getFirstName() + "'! ");

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

	
	public void update_lastName_ByEmail(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set lastName=? where email=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getLastName());

			statement.setString(2, user.getEmail());

			statement.executeUpdate();
			System.out.println("users (with email= '" + user.getEmail() + "') lastName was change on: '"
					+ user.getLastName() + "'! ");

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

	
	public void update_Role_ByEmail(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set role=? where email=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getRole().toString());
			statement.setString(2, user.getEmail());

			statement.executeUpdate();
			System.out.println("users (with email= " + "'" + user.getEmail() + "') role was change on '"
					+ user.getRoleString() + "'! ");

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

	
	public void update_IsBanned_ByEmail(User user) {

		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " update user set isbanned=? where email=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setBoolean(1, user.getIsBaned());
			statement.setString(2, user.getEmail());

			statement.executeUpdate();
			System.out.println("users (email= " + "'" + user.getEmail() + "') flag 'IsBanned' was change on '"
					+ user.getIsBaned() + "'! ");

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
			System.out.println("User :'" + user.getEmail() +"', '"+user.getFirstName()+"', '"+user.getLastName()+ "', role: '"+user.getRoleString()+"', isBaned: '"+user.getIsBaned()+ "' was deleted!");

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

	
	public void deleteByEmail(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " delete  from user where email=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());

			statement.executeUpdate();
			System.out.println("User with email= '" + user.getEmail() + "' was deleted!");

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

	
	public Integer getIdByEmail(User user) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " select id  from user where email=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			user.setId(resSet.getInt("id"));
			System.out.println("User with email= '" + user.getEmail() + "' has id= '"+user.getId()+"';");

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
		String sql = " update user set password = ?,role=?, isbanned=? where email=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);

			
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getRoleString());
			statement.setBoolean(3, user.getIsBaned());
			statement.setString(4, user.getEmail());
			statement.executeUpdate();
			System.out.println("users (Email: '" + user.getEmail() + "') fields was change! :" + "new email= '" + user.getEmail()
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
	
	}


