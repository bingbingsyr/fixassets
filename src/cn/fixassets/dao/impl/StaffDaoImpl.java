/**
 * created by sherry 2016-7-12
 */
package cn.fixassets.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fixassets.dao.BaseDao;
import cn.fixassets.dao.StaffDao;
import cn.fixassets.entity.Staff;
public class StaffDaoImpl extends BaseDao implements StaffDao{

/**
 * 新增职员	
 */
	@Override
	public int save(Staff staff) {
		// TODO Auto-generated method stub
		String sql="insert into staff (id,name,job,remarks)values(?,?,?,?)";
		Object[]param={staff.getId(),staff.getName(),staff.getJob(),staff.getRemarks()};
		int result=this.exceuteUpdate(sql, param);
		
		return result;
	}
/**
 * 通过编号删除职员
 */
	@Override
	public int del(Staff staff) {
		// TODO Auto-generated method stub
		String sql="delete staff where id=?";
		Object[]param={staff.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
/**
 * 通过编号更新职员备注
 */
	@Override
	public int update(Staff staff) {
		// TODO Auto-generated method stub
		String sql="update staff set remarks=? where id=?";
		Object[] param={staff.getRemarks(),staff.getId()};
		int result=this.exceuteUpdate(sql, param);
	return result;	
	}
/**
 * 通过编号查找职员
 */
@Override
public Staff getById(int id) {
	// TODO Auto-generated method stub
	Staff staff=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		conn=this.getConnection();
		String sql="select * from staff where id=? ";//like 
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,id);//"%"+name+"%"
		rs=pstmt.executeQuery();
		if(rs.next()){
			staff=new Staff();
			staff.setId(rs.getInt("id"));
			staff.setName(rs.getString("name"));
			staff.setJob(rs.getString("job"));
			staff.setRemarks(rs.getString("remarks"));
		}
	}
	catch(SQLException ex){
		ex.printStackTrace();
	}
	finally{
		this.closeAll(conn,pstmt,rs);
	}
	return staff;
}
/**
 * 通过职员名字查找职员
 */
@Override
public List<Staff> findByName(String name) {
	// TODO Auto-generated method stub
	List<Staff>liststaff=new ArrayList<Staff>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Staff staff=null;
	try{
		conn=this.getConnection();
		String sql="select * from staff where name=? "; 
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs=pstmt.executeQuery();
		if(rs.next()){
			staff=new Staff();
			staff.setId(rs.getInt("id"));
			staff.setName(rs.getString("name"));
			staff.setJob(rs.getString("job"));
			staff.setRemarks(rs.getString("remarks"));
			liststaff.add(staff);
		}
	}
	catch(SQLException ex){
		ex.printStackTrace();
	}
	finally{
		this.closeAll(conn,pstmt,rs);
	}
	return  liststaff;
}
}
