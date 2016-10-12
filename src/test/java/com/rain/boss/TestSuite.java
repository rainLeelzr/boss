package com.rain.boss;

import com.rain.boss.perm.biz.RoleBizTest;
import com.rain.boss.perm.biz.UserBizTest;
import com.rain.boss.perm.biz.UserRoleBizTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({RoleBizTest.class, UserBizTest.class, UserRoleBizTest.class})
public abstract class TestSuite {
}
