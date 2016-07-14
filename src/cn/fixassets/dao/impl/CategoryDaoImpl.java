package cn.fixassets.dao.impl;
/**
 * time 2016.7.13
 * @author 刘昊
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fixassets.dao.BaseDao;
import cn.fixassets.dao.CategoryDao;
import cn.fixassets.entity.Category;
import cn.fixassets.entity.FixAssets;
public class CategoryDaoImpl   extends BaseDao implements CategoryDao{

	public int save(Category cg) {
		// TODO 自动生成的方法存根
		String sql="insert into category(cateid,catename,subcateid,subcatename) values(?,?,?,?)";
		Object []param={cg.getCateid(),cg.getCatename(),cg.getSubcateid(),cg.getSubcatename()	};
	    int result=	this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public int del(String name) {
		// TODO 自动生成的方法存根
		String sql = "delete category where catename=? or subcatename=?";
		Object[] param = { name,name};
		int result = this.exceuteUpdate(sql, param);
		return result;
		
	}

	@Override
	public List<String> findCateName() {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<String> list=new ArrayList<String>();
		try {
			conn = this.getConnection();
			String sql = "select * from category ";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
		       if(!list.contains(rs.getString("catename"))){
		    	   list.add(rs.getString("catename"));
		       }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
		
	}

	@Override
	public List<String>findSubName() {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<String> list=new ArrayList<String>();
		try {
			conn = this.getConnection();
			String sql = "select * from category ";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
		       if(!list.contains(rs.getString("subcatename"))){
		    	   list.add(rs.getString("subcatename"));
		       }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return list;
	}

	

	@Override
	public List<FixAssets> findCateAssets(String cateName) {
		// TODO 自动生成的方法存根
		List<FixAssets> listAssets=new ArrayList<FixAssets>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FixAssets fa = null;
		try {
			conn = this.getConnection();
			String sql = "select * from assets where typecate=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cateName);
			rs = psmt.executeQuery();
			while (rs.next()) {
				fa=new FixAssets();
			    fa.setId(rs.getString("id"));
				fa.setName(rs.getString("name"));
				fa.setTypecate(rs.getString("typecate"));
				fa.setTypesub(rs.getString("typesub"));
				fa.setModel(rs.getString("model"));
				fa.setPrice(rs.getInt("price"));
				fa.setDate(rs.getDate("buydate"));
				fa.setState(rs.getString("state"));
				fa.setUsers(rs.getString("users"));
				fa.setRemarks(rs.getString("remarks"));
				listAssets.add(fa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return listAssets;
	}

	@Override
	public List<FixAssets> findSubAssets(String subName) {
		// TODO 自动生成的方法存根
		List<FixAssets> listAssets=new ArrayList<FixAssets>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FixAssets fa = null;
		try {
			conn = this.getConnection();
			String sql = "select * from assets where typesub=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, subName);
			rs = psmt.executeQuery();
			while (rs.next()) {
				fa=new FixAssets();
			    fa.setId(rs.getString("id"));
				fa.setName(rs.getString("name"));
				fa.setTypecate(rs.getString("typecate"));
				fa.setTypesub(rs.getString("typesub"));
				fa.setModel(rs.getString("model"));
				fa.setPrice(rs.getInt("price"));
				fa.setDate(rs.getDate("buydate"));
				fa.setState(rs.getString("state"));
				fa.setUsers(rs.getString("users"));
				fa.setRemarks(rs.getString("remarks"));
				listAssets.add(fa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return listAssets;
	}

	@Override
	public Category findCate(String id) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
	    Category cg=null;
		try {
			conn = this.getConnection();
			String sql = "select * from category where cateid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
			  cg=new Category();
		      cg.setCateid(rs.getString("cateid"));
		      cg.setCatename(rs.getString("catename"));
		      cg.setSubcateid(rs.getString("subcateid"));
		      cg.setSubcatename(rs.getString("subcatename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return cg;
	}

	@Override
	public Category findSubCate(String id) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
	    Category cg=null;
		try {
			conn = this.getConnection();
			String sql = "select * from category where subcateid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				 cg=new Category();
		      cg.setCateid(rs.getString("cateid"));
		      cg.setCatename(rs.getString("catename"));
		      cg.setSubcateid(rs.getString("subcateid"));
		      cg.setSubcatename(rs.getString("subcatename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return cg;
	}

}
