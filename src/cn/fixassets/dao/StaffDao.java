/**
 * created by sherry 2016-7-12
 * 职员接口
 */
package cn.fixassets.dao;
import java.util.List;

import cn.fixassets.entity.Staff;
public interface StaffDao {
	int save(Staff staff);//新增职员
	int del(Staff staff);//删除职员
	int update(Staff staff);//更新职员信息
	Staff getById(int id);//通过编号查找职员
	List<Staff>findByName(String name);//通过职员名字查询
}
