package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.DataPerm;
import com.rain.boss.perm.service.DataPermService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class DataPermBiz {
    @Resource
    DataPermService dataPermService;

    public int add(DataPerm entity) {
        return dataPermService.add(entity);
    }

    public int batchAdd(Collection<DataPerm> entitys) {
        return dataPermService.batchAdd(entitys);
    }

    public int delete(String id) {
        return dataPermService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return dataPermService.deleteByIds(ids);
    }

    public int update(DataPerm entity) {
        return dataPermService.update(entity);
    }

    public DataPerm get(String id) {
        return dataPermService.get(id);
    }

    public int countAll() {
        return dataPermService.countAll();
    }

    public List<DataPerm> find(Map<String, ?> params) {
        return dataPermService.find(params);
    }

    public int count(Map<String, ?> params) {
        return dataPermService.count(params);
    }
}