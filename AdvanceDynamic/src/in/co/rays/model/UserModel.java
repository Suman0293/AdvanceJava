package in.co.rays.model;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import in.co.rays.bean.Marksheet2Bean;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {

	public void delete(int id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("Data Deleted = " + i);
	}

	public Integer NextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");

		ps.setInt(1, NextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLogin_id());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());

		int i = ps.executeUpdate();
		System.out.println("Data Added = " + i);
	}
	
	
	

	public void update(UserBean bean) throws Exception {

		try {

			System.out.println("in do post user model update");
			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update user set first_name = ?, last_name = ?, login_id = ?, password = ?, dob = ?, address = ? where id = ?");

			ps.setString(1, bean.getFirstName());
			ps.setString(2, bean.getLastName());
			ps.setString(3, bean.getLogin_id());
			ps.setString(4, bean.getPassword());
			ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			ps.setString(6, bean.getAddress());
			ps.setInt(7, bean.getId());

			System.out.println();

			int i = ps.executeUpdate();
			System.out.println("Data Updated = " + i);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean findByPK(int id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}
		return bean;

	}

	public UserBean Authenticate(String Login_id, String Password) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where login_id=? and password=?");

		ps.setString(1, Login_id);
		ps.setString(2, Password);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		return bean;

	}

//	public List searchDob(UserBean bean, int pageNo, int pageSize) throws Exception {
//
//		Connection conn = JdbcDataSource.getConnection();
//		StringBuffer sql = new StringBuffer("select * from user where 1=1");
//
//		if (bean != null) {
//			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
//				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
//			}
//		}
//
//		System.out.println(sql);
//
//		PreparedStatement ps = conn.prepareStatement(sql.toString());
//
//		List list = new ArrayList();
//		ResultSet rs = ps.executeQuery();
//
//		while (rs.next()) {
//			bean = new UserBean();
//
//			bean.setId(rs.getInt(1));
//			bean.setFirstName(rs.getString(2));
//			bean.setLastName(rs.getString(3));
//			bean.setLogin_id(rs.getString(4));
//			bean.setPassword(rs.getString(5));
//			bean.setDob(rs.getDate(6));
//			bean.setAddress(rs.getString(7));
//
//			list.add(bean);
//
//		}
//		return list;
//
//	}

	public List Search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");

				if (bean.getDob() != null && bean.getDob().getTime() > 0) {
					sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
				}
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
		}
		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
		    //bean.setDob(new java.sql.Date(bean.getDob().getTime()));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

			list.add(bean);

		}
		return list;

	}

}
