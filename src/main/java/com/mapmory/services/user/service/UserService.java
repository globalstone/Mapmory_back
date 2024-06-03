package com.mapmory.services.user.service;

import java.util.List;
import java.util.Map;

import com.mapmory.common.domain.Search;
import com.mapmory.services.user.domain.LoginLog;
import com.mapmory.services.user.domain.SocialLoginInfo;
import com.mapmory.services.user.domain.User;

public interface UserService {
	
	// addLeaveAccount를 이거로 처리
	public boolean addUser(User user);
	
	public boolean addSuspendUser(User user);
	
	public boolean addSocialLoginLink(SocialLoginInfo socialLoginInfo);

	// getProfile, getUserInfo 모두 이거로 처리
	public User getDetailUser(String userId);
	
	public String getId(User user);
	
	// 0: google, 1: naver, 2: kakao
	public String getSocialId(String userId, int type);
	
	/*
	 * List와 count를 Map으로 같이 묶어서 controller에게 전달할 것
	 */
	public Map<String, Object> getUserList(Search search);
	
	public Map<String, Object> getFollowList(Search search);
	
	public List<LoginLog> getUserStatistics();
	
	// updateUserInfo, updateProfile, updatePassword, updateSecondaryAuth 모두 이거로 처리
	public int updateUser(User user);
	
	public int updateSuspendUser(String userId);
	
	public int updateRecoverAccount(String userId);
	
	public boolean checkSecondaryAuth(String userId);
	
	public boolean checkDuplication(User user);

	// 이용약관은 file io 로 처리할 예정
	public Map<String, Object> getTermsAndConditionsList();
	
	public Object getDetailTermsAndConditions();
}
