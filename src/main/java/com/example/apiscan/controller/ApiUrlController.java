package com.example.apiscan.controller;

import com.example.apiscan.pojo.ApiUrlDo;
import com.example.apiscan.service.ApiUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 11:45
 * @version: IT2022
 * @Description:
 */
@RestController
public class ApiUrlController {

    @Resource
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    ApiUrlService apiUrlService;

    /**
     * 获取所有类中被@RequestMapping标注过的方法的对象，并将其存储下来
     */
    @RequestMapping("/getAllApi")
    public void getAllApiUrl(){
        Map<RequestMappingInfo, HandlerMethod> handlerMethods =requestMappingHandlerMapping.getHandlerMethods();
        apiUrlService.addApiUrl(handlerMethods);
    }

    /**
     * 查询所有的api
     * @return
     */
    @RequestMapping("/getAll")
    public List<ApiUrlDo> getAll(@RequestParam String unused){
        return apiUrlService.getAllApi();
    }

    /**
     * 查询所有的api以json格式返回
     * @return
     */
    @RequestMapping("/getAllApiJson")
    public void getAllApiJson() throws Exception {
       apiUrlService.getAllApiJson();
    }


}
