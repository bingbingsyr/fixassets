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
		System.out.println("���ù��̣�");
		System.out.println("�ɽ���Դ���£�");
		//��staff��
		try {
			stmt5= (a.getConnection()).createStatement();
			rs5 = stmt5.executeQuery("with aa(id,name,job,remarks) as (select *from staff where remarks='�������')select min(aa.id)from aa");
			if(rs5.next()){
				number = rs5.getInt(1);
				//System.out.print(rs5.getInt(1));
			}
		stmt= (a.getConnection()).createStatement();
		rs=stmt.executeQuery("select *from staff where remarks = '�������'");
		if(rs.next()){
			//��assets��
			stmt2= (a.getConnection()).createStatement();
			rs2=stmt2.executeQuery("select *from assets where state = '����'");
			while(rs2.next()){
				System.out.println("���\t����\t�������\tС������\t�ͺ�\t��ֵ\t��������\t״̬\tʹ����\t��ע");
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
		//����operator��
			System.out.println("������Դ��ţ�");
		    String assetsid = input.next();
			System.out.println("���������ڣ�");
			String lenddate = input.next();
			System.out.println("����Ԥ�ƹ黹���ڣ�");
			String returndate = input.next();
			System.out.println("�������Ա��");
			String lendmanager = input.next();
			System.out.println("�黹����Ա��");
			String returnmanager = input.next();
			System.out.println("�����;��");
			String purpose = input.next();
			System.out.println("��ע��");
			String remarks = input.next();
			String sql = "insert into operator(assetsid,lenddate,returndate,lendmanager,returnmanager,purpose,remarks)values('"+assetsid+"','"+lenddate+"','"+returndate+"','"+lendmanager+"','"+returnmanager+"','"+purpose+"','"+remarks+"')";
			statement = (a.getConnection()).createStatement();
			statement.execute(sql);
			stmt= (a.getConnection()).createStatement();
			//System.out.println("operator���³ɹ�!");
			//����staff
			String sql3 = "update staff set remarks = '��ͨ��'where id = '"+number+"'";
			statement3 = (a.getConnection()).createStatement();
			statement3.execute(sql3);
			stmt3= (a.getConnection()).createStatement();
			//System.out.println("staff���³ɹ�!");
			//����assets
			String sql4 = "update assets set state = '������',users = '"+rs.getString(2)+"'where id = '"+assetsid+"'";
			statement4 = (a.getConnection()).createStatement();
			statement4.execute(sql4);
			stmt4= (a.getConnection()).createStatement();
			//System.out.println("assets���³ɹ�!");
			System.out.println("���óɹ�!");
			
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void returnAssets() {
		System.out.println("�黹���̣�");
		//����operator
		Statement stmt=null,stmt3 = null;
		ResultSet rs=null;
		Statement statement=null,statement2=null,statement3=null;
	    Scanner input = new Scanner(System.in);
		BaseDao a = new BaseDao();
		System.out.println("�������ʲ���ţ�");
		String assetsid=input.next();
        String sql = "delete from operator where assets = '"+assetsid+"'";
		try {
			statement = (a.getConnection()).createStatement();
			statement.execute(sql);
		    stmt= (a.getConnection()).createStatement();
		    //System.out.println("operatorɾ���ɹ�!");
		  //����assets
			String sql2 = "update assets set state = '����',users = '0'where id = '"+assetsid+"'";
			statement2 = (a.getConnection()).createStatement();
			statement2.execute(sql2);
			stmt2= (a.getConnection()).createStatement();
			//System.out.println("assets���³ɹ�!");
			//����staff
			String sql3 = "delete from staff where id = '"+number+"'";
				statement3 = (a.getConnection()).createStatement();
				statement3.execute(sql3);
			    stmt3= (a.getConnection()).createStatement();
			    //System.out.println("staffɾ���ɹ�!");
			    System.out.println("�黹�ɹ�!");
			
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
			System.out.println("1.�����ʲ�\n2.�黹�ʲ�\n3.������һ��");
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
				System.out.println("�������������");
			}
			}while(flag);
		
	}
  
}
