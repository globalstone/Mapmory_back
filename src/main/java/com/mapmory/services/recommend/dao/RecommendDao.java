package com.mapmory.services.recommend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommendDao {

	public void addSearchData(String userId, String keyword) throws Exception;
	
	public List<String> getSearchData(String userId) throws Exception;
	
	public String getCategory(int categoryNo) throws Exception;
	
	public String getCategoryName(int recordNo) throws Exception;
	
	public List<String> getHashTagNames(int recordNo) throws Exception;
	
}
