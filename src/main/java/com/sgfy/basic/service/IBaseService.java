package com.sgfy.basic.service;

import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.org.domain.Department;
import com.sgfy.org.domain.Employee;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-03-01-Wednesday
 */
public interface IBaseService<T,Q> {

    List<T> selectAll();


}
