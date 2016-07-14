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
		System.out.println("�������û�����");
		String name = input.next();
		System.out.println("���������룺");
		String password = input.next();
		Master mas = new Master();
		mas.setName(name);
		mas.setPassword(password);
		MasterDao masterDao = new MasterImpl();
		master = masterDao.findMaster(mas);
		if (master == null) {
			System.out.println("����ʧ�ܣ��û�����������������������룺");
             Login();
		} else {
			System.out.println("����ɹ�");
			
		}
		
		
	}

	@Override
	public void Revise() {
		 Master master = null;
			Scanner input = new Scanner(System.in);
			System.out.println("�������û�����");
			String name = input.next();
			System.out.println("���������룺");
			String password = input.next();
			Master mas = new Master();
			mas.setName(name);
			mas.setPassword(password);
			MasterDao masterDao = new MasterImpl();
			master = masterDao.findMaster(mas);
			System.out.println("�����µ�����");
			String pass = input.next();
			master.setPassword(pass);
			int result = masterDao.upDate(master);
			if (result == 1) {
				System.out.println("���³ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
			
	}

	@Override
	public void MasterMain() {
		Scanner input = new Scanner(System.in);
		int result=1;
		do{
		System.out.println("***********************************************");
		System.out.println("1.��¼\t\t2.�޸�����");
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
			System.out.println("����������");
	   }
	   
	}while(result>0);
		
	}
 
}
