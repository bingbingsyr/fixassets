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
 * @time 2016-7-12 �̶��ʲ���Ϣ�������ʵ��
 * 
 * @author bingbingsyr
 * @time 2016-07-14 z����AssetsMain()����
 */
public class FixAssetsMessManageImpl implements FixAssetsMessManage {
	private FixAssetsDao fixAssetsDao = new FixAssetsDaoImpl();// ����˽�г�Ա����FixAssetsDao�Ķ���fixAssetsDao
	Scanner input = new Scanner(System.in);
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));// �����ӿ���̨�������
    CategoryManageImpl cml=new CategoryManageImpl();
	@Override
	public void showAllFixAssets() {
		// TODO Auto-generated method stub
		List<FixAssets> list = fixAssetsDao.showAllFixAssets();
		if (list.isEmpty()) {
			System.out.println("�ù�˾�����κι̶��ʲ�");
		} else {
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
	public void del() {
		// TODO Auto-generated method stub
		System.out.println("����Ҫɾ�����ʲ��ı��");
		Scanner input = new Scanner(System.in);
		String id = input.next();
		int result = fixAssetsDao.del(id);
		if (result == 1) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		FixAssets fixAssets = new FixAssets();
		boolean is = true;
		FixAssetsDaoImpl fadi = new FixAssetsDaoImpl();
		System.out.println("�����ʲ����");
		String id;
		do {
			id = input.next();
			if (fadi.getFixAssetsById(id) == null) {
				is = false;
			} else {
				System.out.println("������ͬ�ı�ŵ��ʲ������������");
			}
		} while (is);
		fixAssets.setId(id);
		System.out.println("�����ʲ�����");
		String name = input.next();
		fixAssets.setName(name);
		System.out.print("����������ʲ����,�����ʲ�����У�  ");
		cml.findCateName();
		String type1 = input.next();
		fixAssets.setTypecate(type1);
		System.out.print("������С���ʲ����,С���ʲ�����У�  ");
		cml.findSubName();
		String type2 = input.next();
		fixAssets.setTypesub(type2);
		System.out.println("�������ʲ��ͺ�");
		String model;
		try {
			model = stdin.readLine();
			fixAssets.setModel(model);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("�������ʲ��۸�");
		int price = input.nextInt();
		fixAssets.setPrice(price);
		System.out.println("�����빺������:yyyy-mm-dd");
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
		fixAssets.setState("����");
		fixAssets.setUsers("");
		System.out.println("���뱸ע");
		String remark=input.next();
		fixAssets.setRemarks(remark);
		int re = fixAssetsDao.save(fixAssets);
		if (re == 1) {
			System.out.println("��ӳɹ�");
		} else {
			System.out.println("���ʧ��");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("����Ҫ�޸���Ϣ���ʲ��ı��");
		String id = input.next();
		FixAssets fa = fixAssetsDao.getFixAssetsById(id);
		if (fa != null) {
		   System.out.println("������ʲ��µ�״̬��������ά�ޣ����ϣ�");
		   String state=input.next();
		   fa.setState(state);
			int result = fixAssetsDao.update(fa);
			if (result == 1) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} else {
			System.out.println("����ı������");
		}

	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		FixAssets fa = null;

		System.out.println("1.����Ų��� \t2.����ʹ���߲���\t3.������һ��");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("������ҵı��");
			String id = input.next();
			fa = fixAssetsDao.getFixAssetsById(id);
			if (fa != null) {
				System.out.println("���\t\t����\t\t�������\t\tС�����\t\t�ͺ�\t\t��ֵ\t\t��������\t\t״̬\t\tʹ���߱��\t\t��ע");
				System.out.println(fa.getId() + "\t\t" + fa.getName() + "\t\t" + fa.getTypecate() + "\t\t" +fa.getTypesub()+"\t\t"+ fa.getModel()
						+ "\t\t" + fa.getPrice() + "\t\t" + fa.getDate() + "\t\t" + fa.getState() + "\t\t"
						+ fa.getUsers() + "\t\t" + fa.getRemarks());
			} else {
				System.out.println("�޴˱�ŵĹ̶��ʲ�");
			}
			break;
		case 2:
			System.out.println("������ҵ�ʹ���߱��");
			String name = input.next();
			List<FixAssets> list = fixAssetsDao.getFixAssetsByName(name);
			if (list.isEmpty()) {
				System.out.println("����Ա��ʱû��ʹ���κ��ʲ�");
			} else {
				System.out.println("���\t\t����\t\t�������\t\tС�����\t\t�ͺ�\t\t��ֵ\t\t��������\t\t״̬\t\tʹ���߱��\t\t��ע");
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
			System.out.println("�������������");

		}

	}

	@Override
	public void AssetsMain() {
	    boolean flag=true;
	    Scanner input=new Scanner(System.in);
		do{
		System.out.println("***********************************************");
		System.out.println("1.��ӹ̶��ʲ�\n2.���¹̶��ʲ���״̬��Ϣ\n3.ɾ���̶��ʲ�\n4.���ҹ̶��ʲ�\n5.������һ��");
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
			System.out.println("�������������");
		}
		}while(flag);
	}

}
