package cn.fixassets.dao;

import cn.fixassets.entity.Master;

/**
 * 
 * @author bingbingsyr
 * @time   2016-07-12
 */
public interface MasterDao {
	//修改密码
	int upDate(Master master);
	//查询是否存在
	Master findMaster(Master master);
	//打印出所有的管理员
	void showAllMaster();
}
