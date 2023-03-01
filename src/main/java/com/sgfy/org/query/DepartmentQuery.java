package com.sgfy.org.query;

import com.sgfy.basic.query.BaseQuery;
import lombok.Data;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-27-Monday
 */
@Data
public class DepartmentQuery extends BaseQuery {
    private String name;

    private Long managerId;

    private Long parentId;
}
