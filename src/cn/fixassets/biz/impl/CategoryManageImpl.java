package cn.fixassets.biz.impl;
import java.util.List;
import java.util.Scanner;

import cn.fixassets.biz.CategoryManage;
import cn.fixassets.dao.CategoryDao;
import cn.fixassets.dao.impl.CategoryDaoImpl;
import cn.fixassets.entity.Category;
import cn.fixassets.entity.FixAssets;
import cn.fixassets.test.Test;

/**
 * time 2016.7.13
 * @author ���
 *
 * @author bingbingsyr
 * @time 2016-07-14 ����CategoryMain()����
 */
public class CategoryManageImpl implements CategoryManage{
	CategoryDao cd=new CategoryDaoImpl();
	@Override
	public void add() {//����ʲ�
		// TODO �Զ����ɵķ������
	  Category category =new Category();
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ��ӵ��ʲ��Ĵ���ı��");
		String cateid="";
		boolean over=true;
		do{
			cateid=input.next();
			if(cd.findCate(cateid)!=null){
				System.out.println("�˱����ͬ�����������");
			}else{
				over=false;
			}
		}while(over);
		category.setCateid(cateid);
		System.out.println("������Ҫ��ӵ��ʲ��Ĵ��������");
		String catename=input.next();
		category.setCatename(catename);
		System.out.println("������Ҫ��ӵ��ʲ���С��ı��");
		String subcateid="";
		boolean sover=true;
		do{
			subcateid=input.next();
			if(cd.findSubCate(subcateid)!=null){
				System.out.println("�˱����ͬ�����������");
			}else{
				sover=false;
			}
		}while(sover);
		category.setSubcateid(subcateid);
		System.out.println("������Ҫ��ӵ��ʲ���С�������");
		String catesubname=input.next();
		category.setSubcatename(catesubname);
		cd.save(category);
		System.out.println("����ɹ�");
	}

	@Override
	public void del() {
		// TODO �Զ����ɵķ������
		System.out.println("����Ҫɾ���Ĵ����С�������");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		int result=cd.del(name);
		if(result>=1){
			System.out.println("ɾ���ɹ�");
		}
		else{
			System.out.println("ɾ��ʧ��");
		}
	}
	

	@Override
	public void findCateName() {
		// TODO �Զ����ɵķ������
		List<String>list=cd.findCateName();
	    for(int i=0;i<list.size();i++){
	    	System.out.print(list.get(i)+"    ");
	    }
	    System.out.println();
	}

	@Override
	public void findSubName() {
		// TODO �Զ����ɵķ������
		List<String>list=cd.findSubName();
	    for(int i=0;i<list.size();i++){
	    	System.out.print(list.get(i)+"    ");
	    }
	    System.out.println();
		
	}

	@Override
	public void findCateAssets() {
		// TODO �Զ����ɵķ������
		System.out.println("�����������");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		List<FixAssets> list=cd.findCateAssets(name);
		if(list.isEmpty()){
			System.out.println("�޴δ�����ʲ�");
		}else{
			System.out.println("���\t\t����\t\t�������\t\tС�����\t\t�ͺ�\t\t��ֵ\t\t��������\t\t״̬\t\tʹ���߱��\t\t��ע");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).getId() + "\t\t");
				System.out.print(list.get(i).getName() + "\t\t");
				System.out.print(list.get(i).getTypecate() + "\t\t");
				System.out.print(list.get(i).getTypesub()+"\t\t");
				System.out.print(list.get(i).getModel() + "\t\t");
				System.out.print(list.get(i).getPrice() + "\t\t");
				System.out.print(list.get(i).getDate() + "\t\t");
				System.out.print(list.get(i).getState() + "\t\t");
				System.out.print(list.get(i).getUsers() + "\t\t");
				System.out.println(list.get(i).getRemarks());
			}
		}
		
	}

	@Override
	public void findSubAssets() {
		// TODO �Զ����ɵķ������
		System.out.println("����С������");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		List<FixAssets> list=cd.findSubAssets(name);
		if(list.isEmpty()){
			System.out.println("�޴�С����ʲ�");
		}else{
			System.out.println("���\t\t����\t\t�������\t\tС�����\t\t�ͺ�\t\t��ֵ\t\t��������\t\t״̬\t\tʹ���߱��\t\t��ע");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).getId() + "\t\t");
				System.out.print(list.get(i).getName() + "\t\t");
				System.out.print(list.get(i).getTypecate() + "\t\t");
				System.out.print(list.get(i).getTypesub()+"\t\t");
				System.out.print(list.get(i).getModel() + "\t\t");
				System.out.print(list.get(i).getPrice() + "\t\t");
				System.out.print(list.get(i).getDate() + "\t\t");
				System.out.print(list.get(i).getState() + "\t\t");
				System.out.print(list.get(i).getUsers() + "\t\t");
				System.out.println(list.get(i).getRemarks());
			}
		}
	}

	@Override
	public void CategoryMain() {
		Test t=new Test();
		System.out.println("***********************************************");
		System.out.println("1.�������\n2.ɾ�����\n3.���������\n4.��С�����\n������һ��");
		System.out.println("***********************************************");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch(choice){
		case 1:
			add();
			break;
		case 2:
			del();
			break;
		case 3:
			findCateName();
			break;
		case 4:
			 findSubName();
			 break;
		case 5:
			t.choice1();
		     break;
		}
		
	}

}
