package com.rain.boss.perm.biz;

import com.rain.boss.AbstractTestClass;
import com.rain.boss.perm.entity.Role;
import com.rain.boss.util.Page;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.annotation.Resource;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleBizTest extends AbstractTestClass {

    private static Role role;
    private static Collection<Role> roles;
    @Resource
    private RoleBiz roleBiz;

    private Role genRole() {
        Role role = new Role();
        role.setId();
        role.setParentId(UUID.randomUUID().toString());
        role.setRoleName(RandomStringUtils.randomNumeric(4));
        role.setRoleType((byte) RandomUtils.nextInt(1, 3));
        role.setEnabled((byte) RandomUtils.nextInt(0, 2));
        role.setRemark(RandomStringUtils.randomNumeric(60));
        return role;
    }

    @Test
    public void test1Add() {
        role = genRole();
        Assert.assertEquals(1, roleBiz.add(role));
    }

    @Test
    public void test2Get() {
        Role r = roleBiz.get(role.getId());
        Assert.assertEquals(role.toString(), r.toString());
    }

    @Test
    public void test3Find() {
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", role.getParentId());
        params.put("roleName", role.getRoleName());
        params.put("roleType", role.getRoleType());
        params.put("enabled", role.getEnabled());
        params.put("remark", role.getRemark());

        Page page = new Page(1, 10, "id desc");
        params.put("page", page);
        List<Role> roles = roleBiz.find(params);
        Assert.assertEquals(1, roles.size());
    }

    @Test
    public void test4Count() {
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", role.getParentId());
        params.put("roleName", role.getRoleName());
        params.put("roleType", role.getRoleType());
        params.put("enabled", role.getEnabled());
        params.put("remark", role.getRemark());
        Assert.assertEquals(1, roleBiz.count(params));
    }

    @Test
    public void test5Update() {
        Role r = genRole();
        r.setId(role.getId());
        Assert.assertEquals(1, roleBiz.update(r));
    }

    @Test
    public void test6Delete() {
        Assert.assertEquals(1, roleBiz.delete(role.getId()));
    }

    @Test
    public void test7BatchAdd() {
        int testCount = 10;
        roles = new ArrayList<>(testCount);
        for (int i = 0; i < testCount; i++) {
            roles.add(genRole());
        }
        Assert.assertEquals(testCount, roleBiz.batchAdd(roles));
    }

    @Test
    public void test8DeleteByIds() {
        Set<String> roleIds = new HashSet<>();
        roles.forEach(r -> roleIds.add(r.getId()));
        Assert.assertEquals(roleIds.size(), roleBiz.deleteByIds(roleIds));
    }

    @Test
    public void test9CountAll() {
        roleBiz.countAll();
    }

}
