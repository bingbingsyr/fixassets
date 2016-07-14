package cn.fixassets.dao.impl;
/**
 * @author WangLei
 * @time 2016/7/12
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fixassets.dao.BaseDao;
import cn.fixassets.dao.FixAssetsDao;
import cn.fixassets.entity.FixAssets;

public class FixAssetsDaoImpl extends BaseDao implements FixAssetsDao{

	@Override
	public int save(FixAssets fa) {
		// TODO Auto-generated method stub
		String sql = "insert into assets(id,name,typecate,typesub,model,price,buydate,state,users,remarks)values(?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {fa.getId(),fa.getName(),fa.getTypecate(),fa.getTypesub(),fa.getModel(),fa.getPrice(),fa.getDate(),fa.getState(),fa.getUsers(),fa.getRemarks()};
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public int update(FixAssets fa) {
		// TODO Auto-generated method stub
		String sql = "update assets set name=?,typecate=?,typesub=?,model=?,price=?,buydate=?,state=?,users=?,remarks=? where id=?";
		Object[] param = {fa.getName(),fa.getTypecate(),fa.getTypesub(),fa.getModel(),fa.getPrice(),fa.getDate(),fa.getState(),fa.getUsers(),fa.getRemarks(),fa.getId()};
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public int del(String id) {
		// TODO Auto-generated method stub
		String sql = "delete assets where id=?";
		Object[] param = { id };
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public List<FixAssets> showAllFixAssets() {
		// TODO Auto-generated method stub
		List<FixAssets> listAssets=new ArrayList<FixAssets>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FixAssets fa = null;
		try {
			conn = this.getConnection();
			String sql = "select * from assets";
			psmt = conn.prepareStatement(sql);
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
	public List<FixAssets> getFixAssetsByName(String name) {
		// TODO Auto-generated method stub
		List<FixAssets> listAssets=new ArrayList<FixAssets>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FixAssets fa = null;
		try {
			conn = this.getConnection();
			String sql = "select * from assets where users=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
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
	public FixAssets getFixAssetsById(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FixAssets fa = null;
		try {
			conn = this.getConnection();
			String sql = "select * from assets where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return fa;
	}

}
