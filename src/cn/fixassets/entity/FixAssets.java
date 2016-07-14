package cn.fixassets.entity;

import java.util.Date;

/**
 * @author WangLei
 * @time 2016/7/12
 * fix assets 的实体类
 */
public class FixAssets {
	private String id;//固定资产的编号
	private String name;//名称
	private String typecate;//大类编号
	private String typesub;//小类编号
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
	private String model;//型号
	private int price;//价格
	private Date date;//购买日期
	private String state;//状态
	private String users;//使用者
	private String remarks;//备注
	/**
	 * 各种返回与设置函数
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
