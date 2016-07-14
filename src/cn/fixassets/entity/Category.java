package cn.fixassets.entity;
/**
 * time2016.7.13
 * @author 刘昊
 *
 */
public class Category {
	public  String  cateid;  //大类ID
	public String getCateid() {
		return cateid;
	}
	public void setCateid(String string) {
		this.cateid = string;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getSubcateid() {
		return subcateid;
	}
	public void setSubcateid(String subcateid) {
		this.subcateid = subcateid;
	}
	public String getSubcatename() {
		return subcatename;
	}
	public void setSubcatename(String subcatename) {
		this.subcatename = subcatename;
	}
	public String catename;//大类名字
	public String subcateid;//小类ID
	public String subcatename;//小类名字
	
}
