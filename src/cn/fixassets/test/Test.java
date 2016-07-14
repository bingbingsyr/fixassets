package cn.fixassets.test;

import java.util.Scanner;

import cn.fixassets.biz.impl.CategoryManageImpl;
import cn.fixassets.biz.impl.FixAssetsMessManageImpl;
import cn.fixassets.biz.impl.MasterManageImpl;
import cn.fixassets.biz.impl.StaffManageImpl;
import cn.fixassets.dao.impl.OperatorImpl;
/**
 * 
 * @author bingbingsyr
 * @time 2016-07-14
 */
public class Test {
	
	public static void choice1(){
		boolean flag = true;
		CategoryManageImpl category=new CategoryManageImpl();
		FixAssetsMessManageImpl assets=new FixAssetsMessManageImpl();
		Scanner input = new Scanner(System.in);
		do{
		System.out.println("***********************************************");
		System.out.println("1.������\n2.��Ϣ����\n3.������һ��");
		System.out.println("***********************************************");
		int test=input.nextInt();
		if (test== 1) {
			category.CategoryMain();
		} else if (test == 2) {
			assets.AssetsMain();
		} else if (test == 3) {
			flag=false;
		}else{
			System.out.println("���������루1~3��");
		}
		}while(flag);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MasterManageImpl master = new MasterManageImpl();
		StaffManageImpl staff=new StaffManageImpl();
		OperatorImpl user=new OperatorImpl();
		master.MasterMain();
		boolean flag = true;
		do {
			System.out.println("***********************************************");
			System.out.println("1.�ʲ�����\n2.��Ա����\n3.�ʲ��Ľ��ú͹黹\n4.�˳�");
			System.out.println("***********************************************");
			int choice = input.nextInt();
			if (choice == 1) {
				choice1();
			} else if (choice == 2) {
				staff.StaffMain();
			} else if (choice == 3) {
                user.OperaterMain();
			} else if (choice == 4) {
				flag = false;
			}else{
				System.out.println("���������루1~4��");
			}

		} while (flag);
	}
	
	
}
