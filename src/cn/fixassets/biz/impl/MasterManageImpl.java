package cn.fixassets.biz.impl;

import java.util.Scanner;

import cn.fixassets.biz.MasterManager;
import cn.fixassets.dao.MasterDao;
import cn.fixassets.dao.impl.MasterImpl;
import cn.fixassets.entity.Master;
/**
 * 
 * @author bingbingsyr
 * @time   2016-07-12
 */
public class MasterManageImpl implements MasterManager{

	@Override
	public void Login() {
		Master master = null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		Master mas = new Master();
		mas.setName(name);
		mas.setPassword(password);
		MasterDao masterDao = new MasterImpl();
		master = masterDao.findMaster(mas);
		if (master == null) {
			System.out.println("登入失败，用户名或者密码错误，请重新输入：");
             Login();
		} else {
			System.out.println("登入成功");
			
		}
		
		
	}

	@Override
	public void Revise() {
		 Master master = null;
			Scanner input = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String name = input.next();
			System.out.println("请输入密码：");
			String password = input.next();
			Master mas = new Master();
			mas.setName(name);
			mas.setPassword(password);
			MasterDao masterDao = new MasterImpl();
			master = masterDao.findMaster(mas);
			System.out.println("输入新的密码");
			String pass = input.next();
			master.setPassword(pass);
			int result = masterDao.upDate(master);
			if (result == 1) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失败");
			}
			
	}

	@Override
	public void MasterMain() {
		Scanner input = new Scanner(System.in);
		int result=1;
		do{
		System.out.println("***********************************************");
		System.out.println("1.登录\t\t2.修改密码");
		System.out.println("***********************************************");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			Login();
			result=0;
			break;
		case 2:
			Revise();
			break;
	    default:
			System.out.println("请重新输入");
	   }
	   
	}while(result>0);
		
	}
 
}
