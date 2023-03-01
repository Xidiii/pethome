package com.sgfy.org.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sgfy.basic.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_department")
public class Department extends BaseDomain {
    //部门ID
    //部门编号
    @Size(min = 3,max = 6,message = "请输入3-6之间的")
    private String sn;
    //部门名称0
    @NotBlank(message = "不能为空")
    private String name;
    //部门路径
    private String dirPath;
    //部门状态：1启用,0禁用
    private Integer state = 1;
    //部门经理ID
    private Long managerId;
    //上级部门ID
    private Long parentId;

    @Transient
    private String managerName;

    @Transient
    private String parentName;

    @Transient   // 被注解的字段是一个临时字段，不参与表的增删改操作
    private Long[] parentIds;     // 部门的数据结构

    @Transient
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Department> children = new ArrayList<>();
}
