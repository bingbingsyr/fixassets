package cn.fixassets.entity;

import java.util.Date;

/**
 * @author WangLei
 * @time 2016/7/12
 * fix assets ��ʵ����
 */
public class FixAssets {
	private String id;//�̶��ʲ��ı��
	private String name;//����
	private String typecate;//������
	private String typesub;//С����
	public String getTypecate() {
		return typecate;
	}
	public void setTypecate(String typecate) {
		this.typecate = typecate;
	}
	public String getTypesub() {
		return typesub;
	}
	public void setTypesub(String typesub) {
		this.typesub = typesub;
	}
	private String model;//�ͺ�
	private int price;//�۸�
	private Date date;//��������
	private String state;//״̬
	private String users;//ʹ����
	private String remarks;//��ע
	/**
	 * ���ַ��������ú���
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
