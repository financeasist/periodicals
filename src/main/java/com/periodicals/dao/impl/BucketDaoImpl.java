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

	final static String GET_BUCKET_BYID = "select * from bucket where id=?;";
	final static String GET_ALL_BUCKETS = "select * from bucket;";
	final static String DELETE_BUCKET_BYID = " delete  from bucket where id=?;";
	final static String CREATE_BUCKET = "insert into bucket (`user_id`,`periodical_id`,`data`)values(?,?,?);";
	final static String UPDATE_BUCKET_BYID = " update bucket set user_id =?, periodic_id = ?,data=? where id=?; ";
	final static String SET_ISPAID_TRUE_BYID = " update bucket set is_paid = 1, where id=?; ";

	public BucketDaoImpl() {

	}

	public Bucket getByID(int id) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		Bucket bucket = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_BUCKET_BYID);
			statement.setInt(1, id);
			ResultSet resSet = statement.executeQuery();
			resSet.next();
			bucket = new Bucket();
			bucket.setId(resSet.getInt("id"));
			bucket.setPeriodical_id(resSet.getInt("periodical_id"));
			bucket.setUser_id(resSet.getInt("user_id"));
			bucket.setData(resSet.getTimestamp("data"));
			resSet.close();
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
		return bucket;
	}

	public List<Bucket> getAll() {

		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		List<Bucket> list = new ArrayList<Bucket>();
		PreparedStatement statement = null;
		ResultSet resSet;
		try {
			statement = (PreparedStatement) connection.prepareStatement(GET_ALL_BUCKETS);
			resSet = statement.executeQuery();
			while (resSet.next()) {
				Bucket bucket = new Bucket();
				bucket.setId(resSet.getInt("id"));
				bucket.setPeriodical_id(resSet.getInt("periodical_id"));
				bucket.setUser_id(resSet.getInt("user_id"));
				bucket.setData(resSet.getTimestamp("data"));

				list.add(bucket);
				resSet.close();
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

	public void delete(Bucket bucket) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(DELETE_BUCKET_BYID);
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

	public void create(Integer userID, Integer periodicalID, Timestamp date) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(CREATE_BUCKET);
			statement.setInt(1, userID);
			statement.setInt(2, periodicalID);
			statement.setTimestamp(3, date);

			statement.execute();
			System.out.println(" bucket with user_id= '" + userID + "', periodical_id= '" + periodicalID
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

	public void updateByOnefield(Bucket bucket) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;

		try {
			statement = (PreparedStatement) connection.prepareStatement(UPDATE_BUCKET_BYID);
			statement.setInt(1, bucket.getUser_id());
			statement.setInt(2, bucket.getPeriodical_id());
			statement.setInt(3, bucket.getId());
			statement.executeUpdate();
			System.out.println(" bucket id ='" + bucket.getId() + "' was updated!,  new user_id= '"
					+ bucket.getUser_id() + "', new periodical_id= '" + bucket.getPeriodical_id()
					+ "', new operation date = '" + bucket.getData() + "'.");
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

	public void create(Bucket t) {
		// TODO Auto-generated method stub

	}

	public void setIsPaiedTrue(Integer bucketID) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println("Connection succsessfull!");
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(SET_ISPAID_TRUE_BYID);
			statement.setInt(1, bucketID);
			statement.executeUpdate();
			System.out.println(" buckets field 'ispaid' with id= '"+bucketID+"' was change on true!");
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
