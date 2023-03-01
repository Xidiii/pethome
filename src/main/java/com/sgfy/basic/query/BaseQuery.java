package com.sgfy.basic.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
@Data
@ApiModel(value = "BaseQuery",description = "分页传递参数")
@AllArgsConstructor
@NoArgsConstructor
public class BaseQuery {
    @ApiModelProperty(value = "页码")
    private Integer page;
    @ApiModelProperty(value = "一页多少数据")
    private Integer sizi;

    private Long[] ids;
}
