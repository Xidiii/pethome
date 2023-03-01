package com.sgfy.org.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.service.impl.BaseServiceImpl;
import com.sgfy.basic.utils.JsonResult;
import com.sgfy.org.domain.Department;
import com.sgfy.org.mapper.DepartmentMapper;
import com.sgfy.org.query.DepartmentQuery;
import com.sgfy.org.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,DepartmentQuery> implements IDepartmentService {

    @Autowired
    private DepartmentMapper mapper;


    @Override
    public PageList<Department> findPage(DepartmentQuery query) {
        PageHelper.startPage(query.getPage(),query.getSizi());
        List<Department> departments = mapper.getAll(query);
        PageInfo<Department> departmentPageInfo = new PageInfo<>(departments);
        return new PageList(departmentPageInfo.getTotal(),departmentPageInfo.getList());
    }
    @Override
    @CacheEvict(cacheNames = "treeDept",key = "'tree'")
    public void delete(Long id) {
        //根据id获取dirpath
        Department department = mapper.selectByPrimaryKey(id);
        String dirPath = department.getDirPath();
        //分割字符
        String[] split = dirPath.split("/");
        //获取最后一个路径 也就是本身 这里用id来做也可以 将id转换为string类型
        String s = split[split.length-1];
        //获取所有的dirPath
        List<Department> departments = mapper.selectAll();
        //遍历所有Department对象
        for (Department dept : departments) {
            String[] split1 = dept.getDirPath().split("/");
            //如果数组中包含这个表的部门信息 则删除
            if (Arrays.asList(split1).contains(s)){
                mapper.deleteByPrimaryKey(dept.getId());

            }
        }

//        mapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(cacheNames = "treeDept",key = "'tree'")
    public void saveOrUpdate(Department department) {
        // 如果id有值就是修改，否则就是新增
        if (department.getId() == null) {
            // 1. 数据正常新增
            mapper.insertSelective(department);
        }
            update(department);
    }

    public void update(Department department) {
        // 2. 获取父级数据
        Long[] parentIds = department.getParentIds();
        // 3. 判空
        if (parentIds != null && parentIds.length > 0) {
            // 4. 创建一个字符操作对象
            StringBuffer sb = new StringBuffer();
            // 5. 遍历parentIds
            for (int i = 0; i < parentIds.length; i++) {
                sb.append("/" + parentIds[i]);            //  /3/8/9/11
            }
            // 6. 将当前数据的主键添加到dir_path的最后面
            sb.append("/" + department.getId());
            // 7. 给department进行赋值
            department.setDirPath(sb.toString());
            department.setParentId(parentIds[parentIds.length - 1]);
            // 8. 执行修改操作
            mapper.updateByPrimaryKeySelective(department);
        }
    }

    @Override
    public JsonResult delete(BaseQuery baseQuery) {
        Long[] ids = baseQuery.getIds();
        for (Long id : ids) {
            Department department = mapper.selectByPrimaryKey(id);
            if(department!=null){
                delete(id);
            }
        }
        return JsonResult.createSuccess();
    }

    @Override
    @Cacheable(cacheNames = "treeDept",key = "'tree'")
    public JsonResult treeDept() {
        return getJsonResult();
    }

    private JsonResult getJsonResult() {
        List<Department> departments = mapper.selectAll();
        Map<Long,Department> map = new HashMap<>();
        for (Department d : departments){
            map.put(d.getId(),d);
        }
        List<Department> dept = new ArrayList<>();
        for (Department department : departments) {
            if(department.getParentId() == null){
                dept.add(department);
            }else {
                Department department1 = map.get(department.getParentId());
                department1.getChildren().add(department);
            }
        }
        return JsonResult.createSuccess(departments);
    }

    @Override
    public List<Department> getParentDepts() {
        return mapper.getParentDepts();
    }
}
