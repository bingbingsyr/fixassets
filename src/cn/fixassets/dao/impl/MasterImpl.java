package cn.fixassets.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.fixassets.dao.BaseDao;
import cn.fixassets.dao.MasterDao;
import cn.fixassets.entity.Master;



/**
 * 
 * @author bingbingsyr
 * @time   2016-07-12
 */
public class MasterImpl extends BaseDao implements MasterDao{

	@Override
	/**
	 * 登录后可以修改密码
	 */
	public int upDate(Master master) {
		String sql = "update manager set password=? where name=?";
		Object[] param = {master.getPassword(),master.getName()};
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 * 查询是否存在
	 */
	public Master findMaster(Master mas) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Master master = null;
		try {
			conn = this.getConnection();
			String sql = "select * from manager where name=? and password=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mas.getName());
			psmt.setString(2, mas.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				master = new Master();
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		return master;
	}

	@Override
	/**
	 * 显示所有管理员信息
	 */
	public void showAllMaster() {
		System.out.println("显示所有管理员信息********************************");
		System.out.println("id\t\t用户名\t\t密码");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "select * from manager";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("id") + "\t\t");
				System.out.print(rs.getString("name") + "\t\t");
				System.out.println(rs.getString("password") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, psmt, rs);
		}
		System.out.println("显示所有主人信息********************************");
		
	}

}
