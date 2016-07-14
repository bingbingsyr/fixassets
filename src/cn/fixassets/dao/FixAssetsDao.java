package cn.fixassets.dao;

import java.util.List;

import cn.fixassets.entity.FixAssets;

/**
 * @author WangLei
 * @time  2016/7/12
 * ����̶��ʲ�����ɾ���飬�ĵĽӿ�
 */
public interface FixAssetsDao {
	public int save(FixAssets fa);//����̶��ʲ�
	public int update(FixAssets fa);//���¹̶��ʲ���Ϣ
	public int del(String id);//�����ʲ����ɾ���ʲ�
	public List<FixAssets> showAllFixAssets();//��ʾ�����ʲ���Ϣ
	public List<FixAssets> getFixAssetsByName(String staffId);//�����ʲ�ʹ���߲����ʲ�
	public FixAssets getFixAssetsById(String id);//�����ʲ���Ų����ʲ�
}
