package cn.fixassets.dao;

import java.util.List;

import cn.fixassets.entity.FixAssets;

/**
 * @author WangLei
 * @time  2016/7/12
 * 定义固定资产增，删，查，改的接口
 */
public interface FixAssetsDao {
	public int save(FixAssets fa);//保存固定资产
	public int update(FixAssets fa);//更新固定资产信息
	public int del(String id);//根据资产编号删除资产
	public List<FixAssets> showAllFixAssets();//显示所有资产信息
	public List<FixAssets> getFixAssetsByName(String staffId);//根据资产使用者查找资产
	public FixAssets getFixAssetsById(String id);//根据资产编号查找资产
}
