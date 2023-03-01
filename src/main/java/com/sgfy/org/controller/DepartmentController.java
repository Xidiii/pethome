package com.sgfy.org.controller;

import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.utils.JsonResult;
import com.sgfy.org.domain.Department;
import com.sgfy.org.query.DepartmentQuery;
import com.sgfy.org.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */

@Api(value = "DepartmentController",tags = {"部门管理接口"})
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;


    @GetMapping("/select")
    @ApiOperation(value = "",notes = "查询所有数据")
    public JsonResult select(){
        List<Department> departments = service.selectAll();
        return JsonResult.createSuccess(departments);
    }

    @PostMapping("/parentDepts")
    @ApiOperation(value = "",notes = "查询所有数据")
    public JsonResult parentDepts(){
        List<Department> departments = service.getParentDepts();
        return JsonResult.createSuccess(departments);
    }

    //批量删除
    @PostMapping("/deleteAll")
    public JsonResult delete(@RequestBody BaseQuery baseQuery){
        service.delete(baseQuery);
        return JsonResult.createSuccess();
    }


    @PostMapping("/findPage")
    @ApiOperation(value = "",notes = "分页查询数据")
    public JsonResult findpage(@ApiParam(value = "分页参数",readOnly = true) @RequestBody DepartmentQuery query){
        PageList<Department> page = service.findPage(query);
        return JsonResult.createSuccess(page);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "",notes = "根据id删除数据")
    public JsonResult del(@PathVariable("id") Long id){
        try {
            service.delete(id);
            return JsonResult.createSuccess();
        } catch (Exception e) {
            return JsonResult.createError("删除失败");
        }
    }


    @PostMapping("/save")
    @ApiOperation(value = "",notes = "新增或者修改数据")
    public JsonResult saveOrUpdate(@Valid @RequestBody Department department){
        try {
            service.saveOrUpdate(department);
            return JsonResult.createSuccess();
        } catch (Exception e) {
            return JsonResult.createError("操作失败");
        }
    }

    @PostMapping("/treeDept")
    public JsonResult treeDept(){
        return service.treeDept();
    }
}
