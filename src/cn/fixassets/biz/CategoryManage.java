package cn.fixassets.biz;
/**
 * time2016.7.13
 * @author ���
 * 
 * @author bingbingsyr
 * @time 2016-07-14 ����CategoryMain()����
 */
public interface CategoryManage {
		public void add();   //�������
		public void del();	//ɾ�����
		public void findCateName(); //���ݴ����ʲ����ֲ���
	    public void findSubName();//����С���ʲ����ֲ���
	    public void findCateAssets();//������д����ʲ�
	    public void findSubAssets();//�������С���ʲ�
		public void CategoryMain();
	}