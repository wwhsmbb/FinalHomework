package com.conference.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.entity.ConferenceEmployee;
import com.conference.entity.ConferenceMenu;
import com.conference.entity.ConferenceUser;
import com.conference.mapper.LoginMapper;
import com.conference.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private LoginMapper loginMapper;

	//登录用户
	public ConferenceUser loginUser(String loginName, String loginPwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", loginName);
		map.put("loginPwd", loginPwd);
		return loginMapper.loginUser(map);
	}

	//获取左侧菜单
	public List<ConferenceMenu> queryListMenu(String userId) {
		return loginMapper.queryListMenu(userId);
	}

	//登录员工
	public ConferenceEmployee loginEmployee(String loginName, String loginPwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", loginName);
		map.put("loginPwd", loginPwd);
		return loginMapper.loginEmployee(map);
	}

	//获取左侧菜单
	public List<ConferenceMenu> findListMenu(String employeeSno) {
		return loginMapper.findListMenu(employeeSno);
	}
}
