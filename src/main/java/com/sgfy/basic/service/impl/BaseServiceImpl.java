package com.sgfy.basic.service.impl;

import com.sgfy.basic.domain.BaseDomain;
import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.service.IBaseService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-03-01-Wednesday
 */
public class BaseServiceImpl<T extends BaseDomain,Q extends BaseQuery> implements IBaseService<T,Q> {

    @Autowired
    private Mapper<T> mapper;


    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }
}
