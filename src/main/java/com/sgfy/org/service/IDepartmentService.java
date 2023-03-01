package com.sgfy.org.service;

import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.service.IBaseService;
import com.sgfy.basic.utils.JsonResult;
import com.sgfy.org.domain.Department;
import com.sgfy.org.query.DepartmentQuery;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
public interface IDepartmentService extends IBaseService<Department,DepartmentQuery> {

    PageList<Department> findPage(DepartmentQuery query);

    void delete(Long id);

    void saveOrUpdate(Department department);

    JsonResult delete(BaseQuery baseQuery);

    JsonResult treeDept();

    List<Department> getParentDepts();
}
