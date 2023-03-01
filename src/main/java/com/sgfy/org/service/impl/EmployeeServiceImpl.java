package com.sgfy.org.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.service.impl.BaseServiceImpl;
import com.sgfy.org.domain.Department;
import com.sgfy.org.domain.Employee;
import com.sgfy.org.mapper.DepartmentMapper;
import com.sgfy.org.mapper.EmployeeMapper;
import com.sgfy.org.service.IDepartmentService;
import com.sgfy.org.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, BaseQuery> implements IEmployeeService {

    @Autowired
    private EmployeeMapper mapper;


    @Override
    public PageList<Employee> findPage(BaseQuery query) {
        PageHelper.startPage(query.getPage(),query.getSizi());
        List<Employee> departments = mapper.selectAll();
        PageInfo<Employee> departmentPageInfo = new PageInfo<>(departments);
        return new PageList(departmentPageInfo.getTotal(),departmentPageInfo.getList());
    }

    @Override
    public void delete(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        if(employee.getId() == null){
            mapper.insertSelective(employee);
        }else{
            mapper.updateByPrimaryKeySelective(employee);
        }
    }

    @Override
    public List<Employee> getmanagers() {
        return mapper.getmanagers();
    }
}
