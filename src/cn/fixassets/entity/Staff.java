/**
 * created by sherry 2016-7-12
 * 可领取资产人员信息管理
 */
package cn.fixassets.entity;


public class Staff {
	private int id;//人员编号
	private String name;//人员姓名
	private String job;//人员职务
	private String remarks;//人员备注
	/**
	 * 获取人员编号
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置人员id编号
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置人员名字
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取人员职务
	 * @return
	 */
	public String getJob() {
		return job;
	}
	/**
	 * 设置人员职务
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 获取人员备注
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置人员备注
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
