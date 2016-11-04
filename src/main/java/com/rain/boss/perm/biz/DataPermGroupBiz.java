package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.DataPermGroup;
import com.rain.boss.perm.service.DataPermGroupService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class DataPermGroupBiz {
    @Resource
    DataPermGroupService dataPermGroupService;

    public int add(DataPermGroup entity) {
        return dataPermGroupService.add(entity);
    }

    public int batchAdd(Collection<DataPermGroup> entitys) {
        return dataPermGroupService.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermGroupService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermGroupService.deleteByIds(ids);
    }

    public int update(DataPermGroup entity) {
        return dataPermGroupService.update(entity);
    }

    public DataPermGroup get(String id) {
        return dataPermGroupService.get(id);
    }

    public int countAll() {
        return dataPermGroupService.countAll();
    }

    public List<DataPermGroup> find(Map<String, ?> params) {
        return dataPermGroupService.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermGroupService.count(params);
    }
}