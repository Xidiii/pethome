package com.sgfy.basic.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-03-01-Wednesday
 */

@Data
public class BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
