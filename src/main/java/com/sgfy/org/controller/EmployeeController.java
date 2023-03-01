package com.sgfy.org.controller;

import com.sgfy.basic.query.BaseQuery;
import com.sgfy.basic.query.PageList;
import com.sgfy.basic.utils.JsonResult;
import com.sgfy.org.domain.Department;
import com.sgfy.org.domain.Employee;
import com.sgfy.org.service.IDepartmentService;
import com.sgfy.org.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */

@Api(value = "DepartmentController",tags = {"部门管理接口"})
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;


    @GetMapping("/select")
    @ApiOperation(value = "",notes = "查询所有数据")
    public JsonResult select(){
        List<Employee> employee = service.selectAll();
        return JsonResult.createSuccess(employee);
    }

    @GetMapping("/managers")
    @ApiOperation(value = "",notes = "查询所有数据")
    public JsonResult managers(){
        List<Employee> employee = service.getmanagers();
        return JsonResult.createSuccess(employee);
    }




    @PostMapping("/findPage")
    @ApiOperation(value = "",notes = "分页查询数据")
    public JsonResult findpage(@ApiParam(value = "分页参数",readOnly = true) @RequestBody BaseQuery query){
        PageList<Employee> page = service.findPage(query);
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
    public JsonResult saveOrUpdate(Employee employee){
        try {
            service.saveOrUpdate(employee);
            return JsonResult.createSuccess();
        } catch (Exception e) {
            return JsonResult.createError("操作失败");
        }
    }
}
