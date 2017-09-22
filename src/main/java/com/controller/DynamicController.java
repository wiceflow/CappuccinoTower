package com.controller;

import com.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by BF on 2017/9/5.
 * 用户动态
 */
public class DynamicController {

    // 注入依赖[DynamicService]
    @Autowired
    DynamicService dynamicService;

    public void addDynamic(){

    }
}
