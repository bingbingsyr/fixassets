package cn.fixassets.dao;

import cn.fixassets.entity.Master;

/**
 * 
 * @author bingbingsyr
 * @time   2016-07-12
 */
public interface MasterDao {
	//�޸�����
	int upDate(Master master);
	//��ѯ�Ƿ����
	Master findMaster(Master master);
	//��ӡ�����еĹ���Ա
	void showAllMaster();
}
