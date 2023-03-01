package com.sgfy.org.mapper;

import com.sgfy.org.domain.Department;
import com.sgfy.org.query.DepartmentQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
public interface DepartmentMapper extends Mapper<Department> {

    List<Department> getAll(DepartmentQuery query);

    List<Department> getParentDepts();
}
