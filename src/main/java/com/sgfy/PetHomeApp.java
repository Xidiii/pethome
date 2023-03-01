package com.sgfy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;


/**
 * project : pethome
 *
 * @author:Sakura
 * @date:2023-02-23-Thursday
 */
@SpringBootApplication
@MapperScan("com.sgfy.*.mapper")
@EnableCaching //启用
public class PetHomeApp {
    public static void main(String[] args){
        SpringApplication.run(PetHomeApp.class,args);
    }
}
