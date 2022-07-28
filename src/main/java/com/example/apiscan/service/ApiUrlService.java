package com.example.apiscan.service;

import com.example.apiscan.pojo.ApiUrlDo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 11:33
 * @version: IT2022
 * @Description:
 */
public interface ApiUrlService {

    /**
     * 新增apiUrl接口映射
     * @param handlerMethods
     */
    void addApiUrl(Map<RequestMappingInfo, HandlerMethod> handlerMethods);

    /**
     * 新增一个新的apiUrl接口映射
     * @param apiUrlDo
     */
    void addOneApi(ApiUrlDo apiUrlDo);

    /**
     * 查询所有的api
     * @return
     */
    List<ApiUrlDo> getAllApi();


    /**
     * 根据path查询接口是否存在
     * @param path
     * @return
     */
    ApiUrlDo getApiByPath(String path);

    /**
     * 查询所有的api，Json格式
     * @return
     */
    void getAllApiJson() throws Exception;
}
