package cn.fixassets.biz.impl;

import java.util.Scanner;

import cn.fixassets.biz.StaffManage;
import cn.fixassets.dao.impl.StaffDaoImpl;
import cn.fixassets.entity.Staff;
import cn.fixassets.test.Test;

public class StaffManageImpl implements StaffManage {

	/**
	 * ���ְԱ
	 * 
	 * @param staff
	 */
	public void add() {
		boolean over = true;
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("������Ҫ�����ְԱid");
		Scanner input = new Scanner(System.in);
		int id;
		do {
			id = input.nextInt();
			if (staffdaoimpl.getById(id) != null) {
				System.out.println("���������ͬ�����������");
			}
			else{
				over=false;
			}
		} while (over);
		staff.setId(id);

		System.out.println("������Ҫ�����ְԱ����");
		// Scanner input=new Scanner(System.in);
		String name = input.next();
		staff.setName(name);
		System.out.println("������Ҫ�����ְԱ��ְ��");
		// Scanner input=new Scanner(System.in);
		String job = input.next();
		staff.setJob(job);

		//System.out.println("������Ҫ�����ְԱ�ı�ע");
		// Scanner input=new Scanner(System.in);
		String remarks = "�������";
		staff.setRemarks(remarks);
		int result = staffdaoimpl.save(staff);
		if (result == 1) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}
	}

	/**
	 * ɾ��ְԱ
	 */
	public void del() {
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("������Ҫɾ����ְԱid");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		staff.setId(id);
		if (staffdaoimpl.getById(id) != null) {
			staffdaoimpl.del(staff);
		}else{
			System.out.println("û���ҵ��ó�Ա");
		}
	}

	/**
	 * ����ְԱ�ı�ע��Ϣ
	 */

	public void update() {
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("������Ҫ���µ�ְԱ���");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		staff.setId(id);
		if (staffdaoimpl.getById(id) != null) {
			System.out.println("������Ҫ���µ�ְԱ��ע");
			String remarks = input.next();
			staff.setRemarks(remarks);
			staffdaoimpl.update(staff);
		} else {
			System.out.println("û���ҵ��ó�Ա");
		}
	}

	@Override
	public void StaffMain() {
		Scanner input=new Scanner(System.in);
		 boolean flag=true;
		 do{
		System.out.println("***********************************************");
		System.out.println("1.����ְԱ\n2.ɾ��ְԱ\n3.����ְԱ��Ϣ\n4.������һ��");
		System.out.println("***********************************************");
		int choice=input.nextInt();
		switch(choice){
		case 1:
			add();
			break;
		case 2:
			del();
			break;
		case 3:
			update();
			break;
		case 4:
			flag=false;
			break;
		default:
			System.out.println("�������������");
	}
	}while(flag);
	}
}
