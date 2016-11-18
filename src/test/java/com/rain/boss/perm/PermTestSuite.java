package com.rain.boss.perm;

import com.rain.boss.perm.service.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataPermGroupServiceTest.class,
        DataPermServiceTest.class,
        DataPermSetServiceTest.class,
        FieldPermServiceTest.class,
        FieldResourceServiceTest.class,
        FunPermServiceTest.class,
        LoginServiceTest.class,
        MenuFunPermServiceTest.class,
        MenuServiceTest.class,
        OrgPositionServiceTest.class,
        OrgServiceTest.class,
        PositionFunPermDataPermSetServiceTest.class,
        PositionFunPermServiceTest.class,
        PositionServiceTest.class,
        RoleMenuServiceTest.class,
        RoleServiceTest.class,
        TableResourceServiceTest.class,
        UserPositionServiceTest.class,
        UserRoleServiceTest.class,
        UserServiceTest.class,
        UserTokenServiceTest.class})
public abstract class PermTestSuite {
}
