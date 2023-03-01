package com.sgfy.org.mapper;

import com.sgfy.org.domain.Employee;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
public interface EmployeeMapper extends Mapper<Employee> {


    List<Employee> getmanagers();
}
