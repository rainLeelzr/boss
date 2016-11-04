package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.DataPermSet;
import com.rain.boss.perm.service.DataPermSetService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class DataPermSetBiz {
    @Resource
    DataPermSetService dataPermSetService;

    public int add(DataPermSet entity) {
        return dataPermSetService.add(entity);
    }

    public int batchAdd(Collection<DataPermSet> entitys) {
        return dataPermSetService.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermSetService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermSetService.deleteByIds(ids);
    }

    public int update(DataPermSet entity) {
        return dataPermSetService.update(entity);
    }

    public DataPermSet get(String id) {
        return dataPermSetService.get(id);
    }

    public int countAll() {
        return dataPermSetService.countAll();
    }

    public List<DataPermSet> find(Map<String, ?> params) {
        return dataPermSetService.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermSetService.count(params);
    }
}