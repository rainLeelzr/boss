package com.rain.boss.baseClass;

import com.rain.boss.baseClass.entity.BaseEntity;
import com.rain.boss.baseClass.mapper.BaseMapper;
import com.rain.boss.baseClass.service.BaseService;
import com.rain.boss.data.page.Page;
import com.rain.boss.data.page.PaginationData;
import com.rain.boss.init.SysParam;
import com.rain.boss.util.DateEditor;
import com.rain.boss.util.PropertyUtils;
import com.rain.boss.web.Resp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Date;
import java.util.Arrays;
import java.util.Map;

/**
 * 所有Controller的父类，用于封装一些公用的逻辑或算法。
 */
public abstract class BaseController<E extends BaseEntity, M extends BaseMapper<E>, S extends BaseService<E, M>> {

    public S service;

    @Autowired
    public void setService(S service) {
        this.service = service;
    }

    /**
     * InitBinder注解的含义是，告诉Spring在请求
     * 开始时(调用Controller方法前)先调用这个方法。
     *
     * @param binder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 声明java.sql.Date类型的参数注入，
        // 由DateEditor来完成。
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    /**
     * 通用的获取实体分页数据
     *
     * @param e    封装实体对象的查询条件
     * @param page 封装分页查询条件
     * @return 返回分页数据的resp对象
     */
    protected Resp commonEntityPage(E e, Page page) throws Exception {
        //字段查询参数
        Map<String, Object> params = PropertyUtils.describeWithoutBlank(e);

        //分页查询参数
        page.calculate();
        params.put(SysParam.PAGE_KEY, page);

        PaginationData entitys = service.findPage(params);
        return Resp.success(entitys);
    }

    /**
     * 通用的实体删除方法
     *
     * @param ids 需要删除的实体id，多个实体以,分割
     * @return 返回是否删除成功的resp对象
     */
    protected Resp commonDelete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return Resp.fail("参数错误，ids为空");
        }
        String[] idArr = ids.split(",");
        if (idArr.length == 1) {
            int count = service.delete(ids);
            return count == 1 ? Resp.success() : Resp.fail();
        } else {
            int count = service.deleteByIds(Arrays.asList(idArr));
            return count == idArr.length ? Resp.success() : Resp.fail();
        }
    }

}
