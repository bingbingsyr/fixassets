package cn.fixassets.biz;

/**
 * 
 * @author bingbingsyr
 * @time   2016-07-12
 */
public interface MasterManager {
	/**
	 * 登录
	 * @return result是否成功登录
	 */
	public void Login();
	/**
	 * 修改密码
	 */
	public void Revise();
	/**
	 * 管理员主页面
	 */
	public void MasterMain();
}