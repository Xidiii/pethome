package com.sgfy.basic.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

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
public class PageList<T> {
    private Long total;
    private List<T> data;
}
