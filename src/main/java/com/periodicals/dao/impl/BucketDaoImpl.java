 package com.periodicals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.periodicals.dao.BucketDao;
import com.periodicals.models.Bucket;
import com.periodicals.util.ConnectionUtil;

public class BucketDaoImpl implements BucketDao {

	public BucketDaoImpl() {

	}

	
	public Bucket getByID(int id) {
		Connection connection = ConnectionUtil.getConnection();
		
		System.out.println("Connection succsessfull!");
		String sql = "select * from bucket where id=?;";
		PreparedStatement statement = null;
		Bucket bucket = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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
		String sql = "select * from bucket; ";
		List<Bucket> list = new ArrayList<Bucket>();
		PreparedStatement statement = null;
		ResultSet resSet;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
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
		String sql = " delete  from bucket where id=?;";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, bucket.getId());
			statement.executeUpdate();
			System.out.println(" bucket with id: '"+bucket.getId()+"' was deleted!");
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
		String sql = "insert into bucket (`user_id`,`periodical_id`,`data`)values(?,?,?);";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, bucket.getUser_id());
			statement.setInt(2, bucket.getPeriodical_id());
			statement.setTimestamp(3, bucket.getData());

			statement.execute();
			System.out.println(" bucket with id ='"+bucket.getId()+"', user_id= '"+
			bucket.getUser_id()+"', periodical_id= '"+bucket.getPeriodical_id()
			+"',  operation date = '"+bucket.getData()+"' was created!");
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
		String sql = " update bucket set user_id =?, periodic_id = ?,data=? where id=?; ";
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, bucket.getUser_id());
			statement.setInt(2, bucket.getPeriodical_id());
			statement.setInt(3, bucket.getId());
			statement.executeUpdate();
			System.out.println(" bucket id ='"+bucket.getId()+"' was updated!,  new user_id= '"+
					bucket.getUser_id()+"', new periodical_id= '"+bucket.getPeriodical_id()
					+"', new operation date = '"+bucket.getData()+"'.");
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
