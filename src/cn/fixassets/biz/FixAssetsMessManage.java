package cn.fixassets.biz;
/**
 * @author WangLei
 * @time 2016/7/12
 * 定义固定资产信息管理的接口
  */
public interface FixAssetsMessManage {
	public void showAllFixAssets();//显示所有固定资产
	public void del();//删除固定资产
	public void add();//添加固定资产
	public void update();//更新固定资产的状态信息
	public void find();//查找固定资产
	public void AssetsMain();
}
