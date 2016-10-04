package com.rain.boss.perm.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rain.boss.perm.entity.User;
import com.rain.boss.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserBizTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private UserBiz userBiz;

	private static User user;

	private static Collection<User> users;

	private User genUser() {
		User user = new User();
		user.setId();
		user.setUserAccount(RandomStringUtils.randomNumeric(4));
		user.setUserPwd("123456");
		user.setUserName(RandomStringUtils.randomNumeric(4));
		user.setGender((byte) RandomUtils.nextInt(1, 3));
		user.setQq(RandomStringUtils.randomNumeric(9));
		user.setTelephone(RandomStringUtils.randomNumeric(8));
		user.setMobilePhone(RandomStringUtils.randomNumeric(11));
		user.setEmail(RandomStringUtils.randomNumeric(11));
		user.setEnabled((byte) RandomUtils.nextInt(1, 3));
		user.setRemark(RandomStringUtils.randomNumeric(60));
		return user;
	}

	@Test
	public void test1Add() {
		user = genUser();
		Assert.assertEquals(1, userBiz.add(user));
	}

	@Test
	public void test2Get() {
		User u = userBiz.get(user.getId());
		Assert.assertEquals(user.toString(), u.toString());
	}

	@Test
	public void test3Find() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userAccount", user.getUserAccount());
		params.put("userPwd", user.getUserPwd());
		params.put("userName", user.getUserName());
		params.put("gender", user.getGender());
		params.put("qq", user.getQq());

		Page page = new Page(1, 10, "id desc");
		params.put("page", page);
		List<User> users = userBiz.find(params);
		Assert.assertEquals(1, users.size());
	}

	@Test
	public void test4Count() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userAccount", user.getUserAccount());
		params.put("userPwd", user.getUserPwd());
		params.put("userName", user.getUserName());
		params.put("gender", user.getGender());
		params.put("qq", user.getQq());
		Assert.assertEquals(1, userBiz.count(params));
	}

	@Test
	public void test5Update() {
		User u = genUser();
		u.setId(user.getId());
		Assert.assertEquals(1, userBiz.update(u));
	}

	@Test
	public void test6Delete() {
		Assert.assertEquals(1, userBiz.delete(user.getId()));
	}

	@Test
	public void test7BatchAdd() {
		int testCount = 10;
		users = new ArrayList<User>(testCount);
		for (int i = 0; i < testCount; i++) {
			users.add(genUser());
		}
		Assert.assertEquals(testCount, userBiz.batchAdd(users));
	}

	@Test
	public void test8DeleteByIds() {
		Set<String> userIds = new HashSet<String>();
		for (User user : users) {
			userIds.add(user.getId());
		}
		Assert.assertEquals(userIds.size(), userBiz.deleteByIds(userIds));
	}

	@Test
	public void test9CountAll() {
		userBiz.countAll();
	}

}
