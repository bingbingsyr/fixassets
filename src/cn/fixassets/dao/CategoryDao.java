package cn.fixassets.dao;

import java.util.List;

import cn.fixassets.entity.Category;
import cn.fixassets.entity.FixAssets;


/**
 * time2016.7.13
 * @author Αυκ»
 *
 */
public interface CategoryDao {
	public int  save(Category cg);
	public int del(String name);
	public Category findCate(String id);
	public Category findSubCate(String id);
    public List<String> findCateName();
    public List<String> findSubName();
    public List<FixAssets> findCateAssets(String cateName);
    public List<FixAssets> findSubAssets(String subName);

}
