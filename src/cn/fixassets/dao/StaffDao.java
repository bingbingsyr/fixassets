/**
 * created by sherry 2016-7-12
 * ְԱ�ӿ�
 */
package cn.fixassets.dao;
import java.util.List;

import cn.fixassets.entity.Staff;
public interface StaffDao {
	int save(Staff staff);//����ְԱ
	int del(Staff staff);//ɾ��ְԱ
	int update(Staff staff);//����ְԱ��Ϣ
	Staff getById(int id);//ͨ����Ų���ְԱ
	List<Staff>findByName(String name);//ͨ��ְԱ���ֲ�ѯ
}
