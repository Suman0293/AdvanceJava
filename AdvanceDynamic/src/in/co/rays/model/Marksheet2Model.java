package in.co.rays.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.Marksheet2Bean;
import in.co.rays.util.JdbcDataSource;

public class Marksheet2Model {
	
	public void Add(Marksheet2Bean bean) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into marksheet2 values(?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());
		ps.setInt(8, bean.getTotal());
		
		int i = ps.executeUpdate();
		System.out.println("Data Added = " + i);
	}

	public void Delete(int id) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from marksheet2 where id=?");
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		System.out.println("Data Deleted = " + i);
		
	}
	
	public void Update(Marksheet2Bean bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update marksheet1 set Physics = ? where id = ?");
		
		ps.setInt(2, bean.getId());
		ps.setInt(1, bean.getPhysics());
		
		int i = ps.executeUpdate();
		System.out.println("Date Updated = " + i);
		
	}
	
	
	public Marksheet2Bean FindByRoll(int id) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from marksheet2 where id=?");
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Marksheet2Bean bean = null;
		while (rs.next()) {
			bean = new Marksheet2Bean();
			
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setTotal(rs.getInt(8));
			
		}
		System.out.println("Data FindByRoll");
		return bean;
	}
	
	public List Search(Marksheet2Bean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();		
		StringBuffer sql = new StringBuffer("select * from marksheet2 where 1=1");
		
		if (bean != null) {
			if (bean.getRollNo() != null &&  bean.getRollNo().length() > 0) {
				sql.append(" and roll_no= '" + bean.getRollNo() + "'");
			}
		}

		if (bean.getFname() != null && bean.getFname().length() > 0) {
			sql.append(" and fname like '" + bean.getFname() + "%'");

		}
		System.out.println(sql);
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ArrayList list = new ArrayList();
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new Marksheet2Bean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
			bean.setTotal(rs.getInt(8));
			list.add(bean);

		}
		return list;

	}

}
