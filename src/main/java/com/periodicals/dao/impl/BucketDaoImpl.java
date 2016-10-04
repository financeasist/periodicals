package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.periodicals.dao.BucketDao;
import com.periodicals.models.Bucket;
import com.periodicals.util.ConnectionUtil;

public class BucketDaoImpl implements BucketDao {

	final static String GET_BUCKET_BY_ID = "select * from bucket where id=?;";
	final static String GET_ALL_BUCKETS = "select * from bucket;";
	final static String DELETE_BUCKET_BY_ID = "delete  from bucket where id=?;";
	final static String CREATE_BUCKET = "insert into bucket (`user_id`,`periodical_id`,`date`)values(?,?,?);";
	final static String UPDATE_BUCKET_BY_ID = " update bucket set user_id =?, periodic_id = ?,date=? where id=?; ";
	final static String SET_ISPAID_TRUE_BY_ID = " update bucket set is_paid = 1, where id=?; ";

	public Bucket getById(int id) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		Bucket bucket = null;
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_BUCKET_BY_ID);
			statement.setInt(1, id);
			resSet = statement.executeQuery();
			resSet.next();
			bucket = new Bucket();
			bucket.setId(resSet.getInt("id"));
			bucket.setPeriodical_id(resSet.getInt("periodical_id"));
			bucket.setUser_id(resSet.getInt("user_id"));
			bucket.setDate(resSet.getTimestamp("date"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resSet.close();
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bucket;
	}

	public List<Bucket> getAll() {

		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		List<Bucket> list = new ArrayList<Bucket>();
		PreparedStatement statement = null;
		ResultSet resSet = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_ALL_BUCKETS);
			resSet = statement.executeQuery();
			while (resSet.next()) {
				Bucket bucket = new Bucket();
				bucket.setId(resSet.getInt("id"));
				bucket.setPeriodical_id(resSet.getInt("periodical_id"));
				bucket.setUser_id(resSet.getInt("user_id"));
				bucket.setDate(resSet.getTimestamp("date"));
				list.add(bucket);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				resSet.close();
				statement.close();
				connection.close();
				System.out.println("Connection is closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void delete(Bucket bucket) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_BUCKET_BY_ID);
			statement.setInt(1, bucket.getId());
			statement.executeUpdate();
			System.out.println(" bucket with id: '" + bucket.getId() + "' was deleted!");
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

	public void delete(Integer bucketId) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_BUCKET_BY_ID);
			statement.setInt(1, bucketId);
			statement.executeUpdate();
			System.out.println(" bucket with id: '" + bucketId + "' was deleted!");
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

	public void create(Integer userId, Integer periodicalId, Timestamp date) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(CREATE_BUCKET);
			statement.setInt(1, userId);
			statement.setInt(2, periodicalId);
			statement.setTimestamp(3, date);
			statement.execute();
			System.out.println(" bucket with user_id= '" + userId + "', periodical_id= '" + periodicalId
					+ "',  operation date = '" + date + "' was created!");
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

	public void updateByOneField(Bucket bucket) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_BUCKET_BY_ID);
			statement.setInt(1, bucket.getUser_id());
			statement.setInt(2, bucket.getPeriodical_id());
			statement.setInt(3, bucket.getId());
			statement.executeUpdate();
			System.out.println(" bucket id ='" + bucket.getId() + "' was updated!,  new user_id= '"
					+ bucket.getUser_id() + "', new periodical_id= '" + bucket.getPeriodical_id()
					+ "', new operation date = '" + bucket.getDate() + "'.");
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

	public void create(Bucket bucket) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(CREATE_BUCKET);
			statement.setInt(1, bucket.getUser_id());
			statement.setInt(2, bucket.getPeriodical_id());
			statement.setTimestamp(3, bucket.getDate());

			statement.execute();
			System.out.println(" bucket with user_id= '" + bucket.getUser_id() + "', periodical_id= '"
					+ bucket.getPeriodical_id() + "',  operation date = '" + bucket.getDate() + "' was created!");
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

	public void setIsPaiedTrue(Integer bucketId) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(SET_ISPAID_TRUE_BY_ID);
			statement.setInt(1, bucketId);
			statement.executeUpdate();
			System.out.println(" buckets field 'ispaid' with id= '" + bucketId + "' was change on true!");
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
}
