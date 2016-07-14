package cn.fixassets.biz;
/**
 * time2016.7.13
 * @author 刘昊
 * 
 * @author bingbingsyr
 * @time 2016-07-14 增加CategoryMain()函数
 */
public interface CategoryManage {
		public void add();   //增加类别
		public void del();	//删除类别
		public void findCateName(); //根据大类资产名字查找
	    public void findSubName();//根据小类资产名字查找
	    public void findCateAssets();//输出所有大类资产
	    public void findSubAssets();//输出所有小类资产
		public void CategoryMain();
	}