package cn.fixassets.entity;
/**
 * time2016.7.13
 * @author ���
 *
 */
public class Category {
	public  String  cateid;  //����ID
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
	public String catename;//��������
	public String subcateid;//С��ID
	public String subcatename;//С������
	
}
