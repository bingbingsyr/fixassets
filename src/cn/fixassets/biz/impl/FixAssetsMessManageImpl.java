package cn.fixassets.biz.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.fixassets.biz.FixAssetsMessManage;
import cn.fixassets.dao.FixAssetsDao;
import cn.fixassets.dao.impl.FixAssetsDaoImpl;
import cn.fixassets.entity.FixAssets;
import cn.fixassets.test.Test;

/**
 * @author WangLei
 * @time 2016-7-12 固定资产信息管理类的实现
 * 
 * @author bingbingsyr
 * @time 2016-07-14 z增加AssetsMain()函数
 */
public class FixAssetsMessManageImpl implements FixAssetsMessManage {
	private FixAssetsDao fixAssetsDao = new FixAssetsDaoImpl();// 定义私有成员变量FixAssetsDao的对象fixAssetsDao
	Scanner input = new Scanner(System.in);
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));// 建立从控制台输入的类
    CategoryManageImpl cml=new CategoryManageImpl();
	@Override
	public void showAllFixAssets() {
		// TODO Auto-generated method stub
		List<FixAssets> list = fixAssetsDao.showAllFixAssets();
		if (list.isEmpty()) {
			System.out.println("该公司暂无任何固定资产");
		} else {
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
	public void del() {
		// TODO Auto-generated method stub
		System.out.println("输入要删除的资产的编号");
		Scanner input = new Scanner(System.in);
		String id = input.next();
		int result = fixAssetsDao.del(id);
		if (result == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		FixAssets fixAssets = new FixAssets();
		boolean is = true;
		FixAssetsDaoImpl fadi = new FixAssetsDaoImpl();
		System.out.println("输入资产编号");
		String id;
		do {
			id = input.next();
			if (fadi.getFixAssetsById(id) == null) {
				is = false;
			} else {
				System.out.println("含有相同的编号的资产，请从新输入");
			}
		} while (is);
		fixAssets.setId(id);
		System.out.println("输入资产名称");
		String name = input.next();
		fixAssets.setName(name);
		System.out.print("请输入大类资产类别,大类资产类别有：  ");
		cml.findCateName();
		String type1 = input.next();
		fixAssets.setTypecate(type1);
		System.out.print("请输入小类资产类别,小类资产类别有：  ");
		cml.findSubName();
		String type2 = input.next();
		fixAssets.setTypesub(type2);
		System.out.println("请输入资产型号");
		String model;
		try {
			model = stdin.readLine();
			fixAssets.setModel(model);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("请输入资产价格");
		int price = input.nextInt();
		fixAssets.setPrice(price);
		System.out.println("请输入购买日期:yyyy-mm-dd");
		String strdate = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fixAssets.setDate(date);
		fixAssets.setState("正常");
		fixAssets.setUsers("");
		System.out.println("输入备注");
		String remark=input.next();
		fixAssets.setRemarks(remark);
		int re = fixAssetsDao.save(fixAssets);
		if (re == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("输入要修改信息的资产的编号");
		String id = input.next();
		FixAssets fa = fixAssetsDao.getFixAssetsById(id);
		if (fa != null) {
		   System.out.println("输入该资产新的状态（正常，维修，报废）");
		   String state=input.next();
		   fa.setState(state);
			int result = fixAssetsDao.update(fa);
			if (result == 1) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} else {
			System.out.println("输入的编号有误");
		}

	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		FixAssets fa = null;

		System.out.println("1.按编号查找 \t2.按名使用者查找\t3.返回上一级");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("输入查找的编号");
			String id = input.next();
			fa = fixAssetsDao.getFixAssetsById(id);
			if (fa != null) {
				System.out.println("编号\t\t名称\t\t大类类别\t\t小类类别\t\t型号\t\t价值\t\t购买日期\t\t状态\t\t使用者编号\t\t备注");
				System.out.println(fa.getId() + "\t\t" + fa.getName() + "\t\t" + fa.getTypecate() + "\t\t" +fa.getTypesub()+"\t\t"+ fa.getModel()
						+ "\t\t" + fa.getPrice() + "\t\t" + fa.getDate() + "\t\t" + fa.getState() + "\t\t"
						+ fa.getUsers() + "\t\t" + fa.getRemarks());
			} else {
				System.out.println("无此编号的固定资产");
			}
			break;
		case 2:
			System.out.println("输入查找的使用者编号");
			String name = input.next();
			List<FixAssets> list = fixAssetsDao.getFixAssetsByName(name);
			if (list.isEmpty()) {
				System.out.println("该人员暂时没有使用任何资产");
			} else {
				System.out.println("编号\t\t名称\t\t大类类别\t\t小类类别\t\t型号\t\t价值\t\t购买日期\t\t状态\t\t使用者编号\t\t备注");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).getId() + "\t\t");
					System.out.print(list.get(i).getName() + "\t\t");
					System.out.print(list.get(i).getTypecate() + "\t\t");
					System.out.println(list.get(i).getTypesub()+"\t\t");
					System.out.print(list.get(i).getModel() + "\t\t");
					System.out.print(list.get(i).getPrice() + "\t\t");
					System.out.print(list.get(i).getDate() + "\t\t");
					System.out.print(list.get(i).getState() + "\t\t");
					System.out.print(list.get(i).getUsers() + "\t\t");
					System.out.println(list.get(i).getRemarks());
				}
			}
			break;
		case 3:
			AssetsMain();
			break;
		default:
			System.out.println("输入的数字有误");

		}

	}

	@Override
	public void AssetsMain() {
	    boolean flag=true;
	    Scanner input=new Scanner(System.in);
		do{
		System.out.println("***********************************************");
		System.out.println("1.添加固定资产\n2.更新固定资产的状态信息\n3.删除固定资产\n4.查找固定资产\n5.返回上一级");
		System.out.println("***********************************************");
		int choice=input.nextInt();
		switch(choice){
		case 1:
			add();
			break;
		case 2:
			update();
			break;
		case 3:
			del();
			break;
		case 4:
			find();
			break;
		case 5:
			flag=false;
			break;
		default:
			System.out.println("输入的数字有误");
		}
		}while(flag);
	}

}
