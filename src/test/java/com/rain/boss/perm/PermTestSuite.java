package com.rain.boss.perm;

import com.rain.boss.perm.biz.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataPermBizTest.class,
        DataPermGroupBizTest.class,
        DataPermSetBizTest.class,
        FieldPermBizTest.class,
        FieldResourceBizTest.class,
        FunPermBizTest.class,
        MenuBizTest.class,
        MenuFunPermBizTest.class,
        OrgBizTest.class,
        OrgPositionBizTest.class,
        PositionBizTest.class,
        PositionFunPermBizTest.class,
        PositionFunPermDataPermSetBizTest.class,
        RoleBizTest.class,
        RoleMenuBizTest.class,
        TableResourceBizTest.class,
        UserBizTest.class,
        UserPositionBizTest.class,
        UserRoleBizTest.class})
public abstract class PermTestSuite {
}
