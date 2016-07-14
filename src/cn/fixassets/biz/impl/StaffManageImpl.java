package cn.fixassets.biz.impl;

import java.util.Scanner;

import cn.fixassets.biz.StaffManage;
import cn.fixassets.dao.impl.StaffDaoImpl;
import cn.fixassets.entity.Staff;
import cn.fixassets.test.Test;

public class StaffManageImpl implements StaffManage {

	/**
	 * 添加职员
	 * 
	 * @param staff
	 */
	public void add() {
		boolean over = true;
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("请输入要加入的职员id");
		Scanner input = new Scanner(System.in);
		int id;
		do {
			id = input.nextInt();
			if (staffdaoimpl.getById(id) != null) {
				System.out.println("编号已有相同，请从新输入");
			}
			else{
				over=false;
			}
		} while (over);
		staff.setId(id);

		System.out.println("请输入要加入的职员姓名");
		// Scanner input=new Scanner(System.in);
		String name = input.next();
		staff.setName(name);
		System.out.println("请输入要加入的职员的职务");
		// Scanner input=new Scanner(System.in);
		String job = input.next();
		staff.setJob(job);

		//System.out.println("请输入要加入的职员的备注");
		// Scanner input=new Scanner(System.in);
		String remarks = "申请借用";
		staff.setRemarks(remarks);
		int result = staffdaoimpl.save(staff);
		if (result == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

	/**
	 * 删除职员
	 */
	public void del() {
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("请输入要删除的职员id");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		staff.setId(id);
		if (staffdaoimpl.getById(id) != null) {
			staffdaoimpl.del(staff);
		}else{
			System.out.println("没有找到该成员");
		}
	}

	/**
	 * 更新职员的备注信息
	 */

	public void update() {
		Staff staff = new Staff();
		StaffDaoImpl staffdaoimpl = new StaffDaoImpl();
		System.out.println("请输入要更新的职员编号");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		staff.setId(id);
		if (staffdaoimpl.getById(id) != null) {
			System.out.println("请输入要更新的职员备注");
			String remarks = input.next();
			staff.setRemarks(remarks);
			staffdaoimpl.update(staff);
		} else {
			System.out.println("没有找到该成员");
		}
	}

	@Override
	public void StaffMain() {
		Scanner input=new Scanner(System.in);
		 boolean flag=true;
		 do{
		System.out.println("***********************************************");
		System.out.println("1.新增职员\n2.删除职员\n3.更新职员信息\n4.返回上一级");
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
			System.out.println("输入的数字有误");
	}
	}while(flag);
	}
}
