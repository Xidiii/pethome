package com.sgfy.org.service;

import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.service.IBaseService;
import com.sgfy.org.domain.Department;
import com.sgfy.org.domain.Employee;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
public interface IEmployeeService extends IBaseService<Employee,BaseQuery> {

    PageList<Employee> findPage(BaseQuery query);

    void delete(Long id);

    void saveOrUpdate(Employee employee);

    List<Employee> getmanagers();
}
