package com.sgfy.org.domain;

import java.util.Date;
import javax.persistence.*;

import com.sgfy.basic.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_shop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends BaseDomain {

    /**
     * 门店名称
     */
    private String name;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 1正常；2锁定；3注销
     */
    private Integer state;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 店铺logo
     */
    private String logo;

    /**
     * 关联的管理员ID
     */
    @Column(name = "admin_id")
    private Long adminId;
}