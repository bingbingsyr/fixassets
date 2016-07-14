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
 * @author 刘昊
 *
 * @author bingbingsyr
 * @time 2016-07-14 增加CategoryMain()函数
 */
public class CategoryManageImpl implements CategoryManage{
	CategoryDao cd=new CategoryDaoImpl();
	@Override
	public void add() {//添加资产
		// TODO 自动生成的方法存根
	  Category category =new Category();
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要添加的资产的大类的编号");
		String cateid="";
		boolean over=true;
		do{
			cateid=input.next();
			if(cd.findCate(cateid)!=null){
				System.out.println("此编号相同，请从新输入");
			}else{
				over=false;
			}
		}while(over);
		category.setCateid(cateid);
		System.out.println("请输入要添加的资产的大类的名称");
		String catename=input.next();
		category.setCatename(catename);
		System.out.println("请输入要添加的资产的小类的编号");
		String subcateid="";
		boolean sover=true;
		do{
			subcateid=input.next();
			if(cd.findSubCate(subcateid)!=null){
				System.out.println("此编号相同，请从新输入");
			}else{
				sover=false;
			}
		}while(sover);
		category.setSubcateid(subcateid);
		System.out.println("请输入要添加的资产的小类的名称");
		String catesubname=input.next();
		category.setSubcatename(catesubname);
		cd.save(category);
		System.out.println("插入成功");
	}

	@Override
	public void del() {
		// TODO 自动生成的方法存根
		System.out.println("输入要删除的大类或小类的名称");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		int result=cd.del(name);
		if(result>=1){
			System.out.println("删除成功");
		}
		else{
			System.out.println("删除失败");
		}
	}
	

	@Override
	public void findCateName() {
		// TODO 自动生成的方法存根
		List<String>list=cd.findCateName();
	    for(int i=0;i<list.size();i++){
	    	System.out.print(list.get(i)+"    ");
	    }
	    System.out.println();
	}

	@Override
	public void findSubName() {
		// TODO 自动生成的方法存根
		List<String>list=cd.findSubName();
	    for(int i=0;i<list.size();i++){
	    	System.out.print(list.get(i)+"    ");
	    }
	    System.out.println();
		
	}

	@Override
	public void findCateAssets() {
		// TODO 自动生成的方法存根
		System.out.println("输入大类名称");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		List<FixAssets> list=cd.findCateAssets(name);
		if(list.isEmpty()){
			System.out.println("无次大类的资产");
		}else{
			System.out.println("编号\t\t名称\t\t大类类别\t\t小类类别\t\t型号\t\t价值\t\t购买日期\t\t状态\t\t使用者编号\t\t备注");
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
		// TODO 自动生成的方法存根
		System.out.println("输入小类名称");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		List<FixAssets> list=cd.findSubAssets(name);
		if(list.isEmpty()){
			System.out.println("无次小类的资产");
		}else{
			System.out.println("编号\t\t名称\t\t大类类别\t\t小类类别\t\t型号\t\t价值\t\t购买日期\t\t状态\t\t使用者编号\t\t备注");
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
		System.out.println("1.增加类别\n2.删除类别\n3.按大类查找\n4.按小类查找\n返回上一级");
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
