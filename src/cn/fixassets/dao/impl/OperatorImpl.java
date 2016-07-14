package cn.fixassets.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.fixassets.dao.BaseDao;
import cn.fixassets.dao.OperatorDao;

public class OperatorImpl extends BaseDao implements OperatorDao {
	Statement stmt=null,stmt2=null,stmt3=null,stmt4=null,stmt5=null;
	ResultSet rs=null,rs2=null,rs5=null;
	Statement statement=null,statement3=null,statement4= null;
	private Scanner input = new Scanner(System.in);
	BaseDao a = new BaseDao();
	int number;
	//String assetsid;
	public void applicationAssets(){
		System.out.println("借用过程：");
		System.out.println("可借资源如下：");
		//查staff表
		try {
			stmt5= (a.getConnection()).createStatement();
			rs5 = stmt5.executeQuery("with aa(id,name,job,remarks) as (select *from staff where remarks='申请借用')select min(aa.id)from aa");
			if(rs5.next()){
				number = rs5.getInt(1);
				//System.out.print(rs5.getInt(1));
			}
		stmt= (a.getConnection()).createStatement();
		rs=stmt.executeQuery("select *from staff where remarks = '申请借用'");
		if(rs.next()){
			//查assets表
			stmt2= (a.getConnection()).createStatement();
			rs2=stmt2.executeQuery("select *from assets where state = '正常'");
			while(rs2.next()){
				System.out.println("编号\t名称\t大类类别\t小类类型\t型号\t价值\t购买日期\t状态\t使用者\t备注");
				System.out.print(rs2.getString(1)+"\t");
				System.out.print(rs2.getString(2)+"\t");
				System.out.print(rs2.getString(3)+"\t");
				System.out.print(rs2.getString(4)+"\t");
				System.out.print(rs2.getString(5)+"\t");
				System.out.print(rs2.getInt(6)+"\t");
				System.out.print(rs2.getDate(7)+"\t");
				System.out.print(rs2.getString(8)+"\t");
				System.out.print(rs2.getString(9)+"\t");
				System.out.print(rs2.getString(10)+"\t");
				System.out.println();
			
			}
		//增加operator表
			System.out.println("输入资源编号：");
		    String assetsid = input.next();
			System.out.println("输入借出日期：");
			String lenddate = input.next();
			System.out.println("输入预计归还日期：");
			String returndate = input.next();
			System.out.println("借出管理员：");
			String lendmanager = input.next();
			System.out.println("归还管理员：");
			String returnmanager = input.next();
			System.out.println("借出用途：");
			String purpose = input.next();
			System.out.println("备注：");
			String remarks = input.next();
			String sql = "insert into operator(assetsid,lenddate,returndate,lendmanager,returnmanager,purpose,remarks)values('"+assetsid+"','"+lenddate+"','"+returndate+"','"+lendmanager+"','"+returnmanager+"','"+purpose+"','"+remarks+"')";
			statement = (a.getConnection()).createStatement();
			statement.execute(sql);
			stmt= (a.getConnection()).createStatement();
			//System.out.println("operator更新成功!");
			//更新staff
			String sql3 = "update staff set remarks = '已通过'where id = '"+number+"'";
			statement3 = (a.getConnection()).createStatement();
			statement3.execute(sql3);
			stmt3= (a.getConnection()).createStatement();
			//System.out.println("staff更新成功!");
			//更新assets
			String sql4 = "update assets set state = '借用中',users = '"+rs.getString(2)+"'where id = '"+assetsid+"'";
			statement4 = (a.getConnection()).createStatement();
			statement4.execute(sql4);
			stmt4= (a.getConnection()).createStatement();
			//System.out.println("assets更新成功!");
			System.out.println("借用成功!");
			
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void returnAssets() {
		System.out.println("归还过程：");
		//更新operator
		Statement stmt=null,stmt3 = null;
		ResultSet rs=null;
		Statement statement=null,statement2=null,statement3=null;
	    Scanner input = new Scanner(System.in);
		BaseDao a = new BaseDao();
		System.out.println("请输入资产编号：");
		String assetsid=input.next();
        String sql = "delete from operator where assets = '"+assetsid+"'";
		try {
			statement = (a.getConnection()).createStatement();
			statement.execute(sql);
		    stmt= (a.getConnection()).createStatement();
		    //System.out.println("operator删除成功!");
		  //更新assets
			String sql2 = "update assets set state = '正常',users = '0'where id = '"+assetsid+"'";
			statement2 = (a.getConnection()).createStatement();
			statement2.execute(sql2);
			stmt2= (a.getConnection()).createStatement();
			//System.out.println("assets更新成功!");
			//更新staff
			String sql3 = "delete from staff where id = '"+number+"'";
				statement3 = (a.getConnection()).createStatement();
				statement3.execute(sql3);
			    stmt3= (a.getConnection()).createStatement();
			    //System.out.println("staff删除成功!");
			    System.out.println("归还成功!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void OperaterMain() {
		 boolean flag=true;
		    Scanner input=new Scanner(System.in);
			do{
			System.out.println("***********************************************");
			System.out.println("1.领用资产\n2.归还资产\n3.返回上一级");
			System.out.println("***********************************************");
			int choice=input.nextInt();
			switch(choice){
			case 1:
				applicationAssets();
				break;
			case 2:
				returnAssets();
				break;
			case 3:
				flag=false;
				break;
			default:
				System.out.println("输入的数字有误");
			}
			}while(flag);
		
	}
  
}
