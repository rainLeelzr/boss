package com.rain.boss.perm.service;

import com.rain.boss.perm.entity.TableResource;
import com.rain.boss.perm.mapper.TableResourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class TableResourceService {
    @Resource
    TableResourceMapper tableResourceMapper;

    public int add(TableResource entity) {
        return tableResourceMapper.add(entity);
    }

    public int batchAdd(Collection<TableResource> entitys) {
        return tableResourceMapper.batchAdd(entitys);
    }

    public int delete(String id) {
        return tableResourceMapper.delete(id);
    }

    public int deleteByIds(Collection<String> ids) {
        return tableResourceMapper.deleteByIds(ids);
    }

    public int update(TableResource entity) {
        return tableResourceMapper.update(entity);
    }

    public TableResource get(String id) {
        return tableResourceMapper.get(id);
    }

    public int countAll() {
        return tableResourceMapper.countAll();
    }

    public List<TableResource> find(Map<String, ?> params) {
        return tableResourceMapper.find(params);
    }

    public int count(Map<String, ?> params) {
        return tableResourceMapper.count(params);
    }
}
