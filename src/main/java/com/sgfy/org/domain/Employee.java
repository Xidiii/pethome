package com.sgfy.org.domain;

import com.sgfy.basic.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-26-Sunday
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_employee")
public class Employee extends BaseDomain {
    private String  username;
    private String  email;
    private String  phone;
    private String  password;
    private Integer  age;
    private Integer  state;
    private Long  departmentId;
    private Long  logininfoId;
    private Long  shopId;
    private Long  parentId;
    private Long  managerId;
}
