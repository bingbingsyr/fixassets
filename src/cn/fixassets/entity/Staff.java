/**
 * created by sherry 2016-7-12
 * ����ȡ�ʲ���Ա��Ϣ����
 */
package cn.fixassets.entity;


public class Staff {
	private int id;//��Ա���
	private String name;//��Ա����
	private String job;//��Աְ��
	private String remarks;//��Ա��ע
	/**
	 * ��ȡ��Ա���
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * ������Աid���
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * ������Ա����
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ��ȡ��Աְ��
	 * @return
	 */
	public String getJob() {
		return job;
	}
	/**
	 * ������Աְ��
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * ��ȡ��Ա��ע
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * ������Ա��ע
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
