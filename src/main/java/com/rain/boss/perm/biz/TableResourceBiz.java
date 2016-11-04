package com.rain.boss.perm.biz;

import com.rain.boss.perm.entity.TableResource;
import com.rain.boss.perm.service.TableResourceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class TableResourceBiz {
    @Resource
    TableResourceService tableResourceService;

    public int add(TableResource entity) {
        return tableResourceService.add(entity);
    }

    public int batchAdd(Collection<TableResource> entitys) {
        return tableResourceService.batchAdd(entitys);
    }

    public int delete(String id) {
        return tableResourceService.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return tableResourceService.deleteByIds(ids);
    }

    public int update(TableResource entity) {
        return tableResourceService.update(entity);
    }

    public TableResource get(String id) {
        return tableResourceService.get(id);
    }

    public int countAll() {
        return tableResourceService.countAll();
    }

    public List<TableResource> find(Map<String, ?> params) {
        return tableResourceService.find(params);
    }

    public int count(Map<String, ?> params) {
        return tableResourceService.count(params);
    }
}