package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.periodicals.dao.PeriodicalDao;
import com.periodicals.models.Periodical;
import com.periodicals.util.ConnectionUtil;

public class PeriodicalDaoImpl implements PeriodicalDao {
	private final static Logger logger = Logger.getLogger(PeriodicalDaoImpl.class); 
	final static String GET_PERIODICAL_BY_ID = "select * from periodical where id=?;";
	final static String GET_ALL_PERIODICALS = "select * from periodical; ";
	final static String UPDATE_PERIODICAL_BY_TITLE = " update periodical set price = ?,isAdded= ?, isPaided=?,discription= ? where title=?; ";
	final static String CREATE_PERIODICAL = "insert into periodical (`title`,`price`,`discription`,`isAdded`,`isPaided`)values(?, ?,?,?,?);";
	final static String DELETE_PERIODICAL_BY_TITLE = " delete  from periodical where title=?;";
	final static String GET_ID_BY_TITLE = " select id  from periodical where title=?;";
	final static String GET_PERIODICAL_BY_TITLE = "select * from periodical where title=?;";

	public Periodical getById(int id) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		Periodical periodical = null;
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_PERIODICAL_BY_ID);
			statement.setInt(1, id);
			resSet = statement.executeQuery();
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
				if (resSet != null)
					resSet.close();
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return periodical;
	}

	public List<Periodical> getAll() {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		List<Periodical> list = new ArrayList<Periodical>();
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_ALL_PERIODICALS);
			resSet = statement.executeQuery();
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
				if (resSet != null)
					resSet.close();
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void updateByOneField(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_PERIODICAL_BY_TITLE);
			statement.setDouble(1, periodical.getPrice());
			statement.setBoolean(2, periodical.getIsAdded());
			statement.setBoolean(3, periodical.getIsPaided());
			statement.setString(4, periodical.getDiscription());
			statement.setString(5, periodical.getTitle());
			statement.executeUpdate();
			logger.info("Periodical : " + "title= '" + periodical.getTitle() + "' was updated! " + ", new price="
					+ "'" + periodical.getPrice() + "'" + ", new discription=" + "'" + periodical.getDiscription() + "'"
					+ ", new isAdded=" + "'" + periodical.getIsAdded() + "'" + ", new isPaided= " + "'"
					+ periodical.getIsPaided() + "'.");
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

	public void create(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(CREATE_PERIODICAL);
			statement.setString(1, periodical.getTitle());
			statement.setDouble(2, periodical.getPrice());
			statement.setString(3, periodical.getDiscription());
			statement.setBoolean(4, periodical.getIsAdded());
			statement.setBoolean(5, periodical.getIsPaided());

			statement.execute();
			logger.info("Periodical : " + "title= " + "'" + periodical.getTitle() + "'" + ", price=" + "'"
					+ periodical.getPrice() + "'" + ", discription=" + "'" + periodical.getDiscription() + "'"
					+ ", isAdded=" + "'" + periodical.getIsAdded() + "'" + ", isPaided= " + "'"
					+ periodical.getIsPaided() + "' created!.");
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

	public void deleteByTitle(String title) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");

		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_PERIODICAL_BY_TITLE);
			statement.setString(1, title);
			statement.executeUpdate();
			logger.info("All periodicals with title= '" + title + "' was deleted!");
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

	public void delete(Periodical periodical) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_PERIODICAL_BY_TITLE);
			statement.setString(1, periodical.getTitle());
			statement.executeUpdate();
			logger.info("All periodicals with title= '" + periodical.getTitle() + "' was deleted!");
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

	public Integer getIdByTitle(String title) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		Periodical periodical = new Periodical();
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_ID_BY_TITLE);
			statement.setString(1, title);
			resSet = statement.executeQuery();
			resSet.next();
			periodical.setId(resSet.getInt("id"));
			periodical.setTitle(title);
			System.out
					.println("User with email= '" + periodical.getTitle() + "' has id= '" + periodical.getId() + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resSet != null)
					resSet.close();
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return periodical.getId();

	}

	public Periodical getPeriodicalByTitle(String title) {
		Connection connection = (Connection) ConnectionUtil.getConnection();
		logger.info("Connection succsessfull!");
		PreparedStatement statement = null;
		Periodical periodical = null;
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_PERIODICAL_BY_TITLE);
			statement.setString(1, title);
			resSet = statement.executeQuery();
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
				if (resSet != null)
					resSet.close();
				statement.close();
				connection.close();
				logger.info("Connection is closed!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return periodical;
	}
}
