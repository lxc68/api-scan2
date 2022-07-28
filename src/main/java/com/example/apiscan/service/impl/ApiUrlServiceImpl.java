package com.example.apiscan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.apiscan.dao.ApiUrlDao;
import com.example.apiscan.pojo.*;
import com.example.apiscan.service.ApiUrlService;
import com.example.apiscan.util.FreeMarkerTemplateUtils;
import com.example.apiscan.util.JsonFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 11:36
 * @version: IT2022
 * @Description:
 */
@Service
public class ApiUrlServiceImpl implements ApiUrlService {

    @Autowired
    private ApiUrlDao apiUrlDao;

    @Autowired
    private JsonFileUtils jsonFileUtils;

    @Override
    public void addApiUrl(Map<RequestMappingInfo, HandlerMethod> handlerMethods) {
        for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
            ApiUrlDo apiUrlDo = new ApiUrlDo();
            RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
            HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
            apiUrlDo.setUrl(requestMappingInfo.getPathPatternsCondition().toString());
            apiUrlDo.setMethodName(mappingInfoValue.getBeanType().getName()+mappingInfoValue.getMethod().getName());
            apiUrlDao.insert(apiUrlDo);
        }
    }

    @Override
    public void addOneApi(ApiUrlDo apiUrlDo) {
        apiUrlDao.insert(apiUrlDo);
    }

    @Override
    public List<ApiUrlDo> getAllApi() {
        return apiUrlDao.getAll();
    }


    @Override
    public ApiUrlDo getApiByPath(String path) {
        return apiUrlDao.selectByPath(path);
    }

    @Override
    public void getAllApiJson() throws Exception {
        String filePath = "collection.ftl";
        FreeMarkerTemplateUtils utils = new FreeMarkerTemplateUtils();
        List<ApiUrlDo> list = apiUrlDao.getAll();
        File file = jsonFileUtils.createJsonFile("requestInfo");
        Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        Collection collection = new Collection();
        Info info = new Info("019b8b42-3c95-472c-8c58-9b2d990df4eb","New Collection","https://schema.getpostman.com/json/collection/v2.1.0/collection.json","21967649");
        collection.setInfo(info);
        List<ApiRequest> apiRequests = new ArrayList<>();

        for(ApiUrlDo apiUrlDo:list){
            Param param1 = new Param("unused","789798");

            Url url = new Url();
            List<String> path = new ArrayList<>();
            path.add("getAll");
            url.setPaths(path);
            url.setRaw("http://localhost:8080/getAll?unused=789798");
            url.setPort("8080");
            url.setProtocol("http");
            List<String> hosts = new ArrayList<>();
            hosts.add("localhost");
            url.setHosts(hosts);
            List<Param> query = new ArrayList<>();
            query.add(param1);
            url.setQuerys(query);
            Request request = new Request();
            request.setMethod("GET");
            request.setUrl(url);
            ApiRequest apiRequest = new ApiRequest("test1",request);
            apiRequests.add(apiRequest);
        }
        collection.setApiRequests(apiRequests);
        Map<String,Object> input = new HashMap<>();
        input.put("collection",collection);
        write.write(utils.getData(filePath,input));
        write.flush();
        write.close();
    }
}
