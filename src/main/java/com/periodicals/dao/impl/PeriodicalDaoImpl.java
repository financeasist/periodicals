package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.periodicals.dao.PeriodicalDao;
import com.periodicals.models.Periodical;
import com.periodicals.util.ConnectionUtil;

public class PeriodicalDaoImpl implements PeriodicalDao {

	public PeriodicalDaoImpl() {
	}

	public Periodical getByID(int id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = "select * from periodical where id=?;";
		PreparedStatement statement = null;
		Periodical periodical = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			periodical = new Periodical();
			periodical.setId(resSet.getInt("id"));
			periodical.setTitle(resSet.getString("title"));
			periodical.setPrice(resSet.getDouble("price"));
			periodical.setDiscription(resSet.getString("discription"));
			periodical.setIsAdded(resSet.getBoolean("isadded"));
			periodical.setIsPaided(resSet.getBoolean("ispaided"));

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
		return periodical;

	}

	
	public List<Periodical> getAll() {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = "select * from periodical; ";
		PreparedStatement statement = null;
		List<Periodical> list = new ArrayList<Periodical>();

		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet resSet = statement.executeQuery();
			while (resSet.next()) {
				Periodical periodical = new Periodical();
				periodical.setId(resSet.getInt("id"));
				periodical.setTitle(resSet.getString("title"));
				periodical.setPrice(resSet.getDouble("price"));
				periodical.setDiscription(resSet.getString("discription"));
				periodical.setIsAdded(resSet.getBoolean("isadded"));
				periodical.setIsPaided(resSet.getBoolean("ispaided"));
				list.add(periodical);
			}
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
		return list;
	}

	
	public void updateByOnefield(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = " update periodical set price = ?,isAdded= ?, isPaided=?,discription= ? where title=?; ";
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);

			statement.setDouble(1, periodical.getPrice());
			statement.setBoolean(2, periodical.getIsAdded());
			statement.setBoolean(3, periodical.getIsPaided());
			statement.setString(4, periodical.getDiscription());
			statement.setString(5, periodical.getTitle());
			statement.executeUpdate();
			System.out.println("Periodical : " + "title= '" + periodical.getTitle() + "' was updated! " + ", new price="
					+ "'" + periodical.getPrice() + "'" + ", new discription=" + "'" + periodical.getDiscription() + "'"
					+ ", new isAdded=" + "'" + periodical.getIsAdded() + "'" + ", new isPaided= " + "'"
					+ periodical.getIsPaided() + "'.");
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

	
	public void create(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = "insert into periodical (`title`,`price`,`discription`,`isAdded`,`isPaided`)values(?, ?,?,?,?);";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, periodical.getTitle());
			statement.setDouble(2, periodical.getPrice());
			statement.setString(3, periodical.getDiscription());
			statement.setBoolean(4, periodical.getIsAdded());
			statement.setBoolean(5, periodical.getIsPaided());

			statement.execute();
			System.out.println("Periodical : " + "title= " + "'" + periodical.getTitle() + "'" + ", price=" + "'"
					+ periodical.getPrice() + "'" + ", discription=" + "'" + periodical.getDiscription() + "'"
					+ ", isAdded=" + "'" + periodical.getIsAdded() + "'" + ", isPaided= " + "'"
					+ periodical.getIsPaided() + "' created!.");
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

	public void deleteByTitle(String title) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = " delete  from periodical where title=?;";
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.executeUpdate();
			System.out.println("All periodicals with title= '" + title + "' was deleted!");
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

	
	public void delete(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = " delete  from periodical where title=?;";
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, periodical.getTitle());
			statement.executeUpdate();
			System.out.println("All periodicals with title= '" + periodical.getTitle() + "' was deleted!");
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

	
	public Integer getIdByTitle(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		String sql = " select id  from periodical where title=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, periodical.getTitle());

			ResultSet resSet = statement.executeQuery();
			resSet.next();
			periodical.setId(resSet.getInt("id"));
			System.out
					.println("User with email= '" + periodical.getTitle() + "' has id= '" + periodical.getId() + "';");

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
		return periodical.getId();

	}

	
	public Periodical getPeriodicalByTitle(String title) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		String sql = "select * from periodical where title=?;";
		PreparedStatement statement = null;
		Periodical periodical = null;
		try {
			
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, title);
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			periodical = new Periodical();
			periodical.setId(resSet.getInt("id"));
			periodical.setTitle(resSet.getString("title"));
			periodical.setPrice(resSet.getDouble("price"));
			periodical.setDiscription(resSet.getString("discription"));
			periodical.setIsAdded(resSet.getBoolean("isadded"));
			periodical.setIsPaided(resSet.getBoolean("ispaided"));

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
		return periodical;
	}

}
