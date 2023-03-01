package com.sgfy.basic.utils;

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
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private String code;
    private String message;
    private Boolean success;
    private Object object;

    public static JsonResult createSuccess(){
        return new JsonResult("0000","操作成功",true,null);
    }

    public static JsonResult createSuccess(Object obj){
        return new JsonResult("0000","操作成功",true,obj);
    }

    public static JsonResult createError(String message){
        return new JsonResult("1001",message,false,null);
    }

    public static JsonResult createError(String code,String message){
        return new JsonResult(code,message,false,null);
    }


}
