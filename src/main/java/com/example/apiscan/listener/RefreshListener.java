package com.example.apiscan.listener;

import com.example.apiscan.pojo.ApiUrlDo;
import com.example.apiscan.service.ApiUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 14:55
 * @version: IT2022
 * @Description: 监听ContextRefreshedEvent事件 --> ApplicationContext初始化或者刷新时会触发的事件
 */
@Component
public class RefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    ApiUrlService apiUrlService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent事件被触发");
        Map<RequestMappingInfo, HandlerMethod> handlerMethods =requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
            RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
            HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
            String url = requestMappingInfo.getPathPatternsCondition().getPatterns().toArray()[0].toString().substring(1);
            if(apiUrlService.getApiByPath(url)==null){
                ApiUrlDo apiUrlDo = new ApiUrlDo();
                apiUrlDo.setUrl(url);
                apiUrlDo.setMethodName(mappingInfoValue.getBeanType().getName()+"."+mappingInfoValue.getMethod().getName());
                apiUrlService.addOneApi(apiUrlDo);
            }
        }
    }
}
