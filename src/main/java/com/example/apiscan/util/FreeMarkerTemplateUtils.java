package com.example.apiscan.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.apiscan.pojo.ApiUrlDo;
import com.example.apiscan.pojo.Collection;
import com.example.apiscan.testfreemarker.Order;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 16:00
 * @version: IT2022
 * @Description: FreeMarker工具类（模板引擎生成json）
 */
public class FreeMarkerTemplateUtils {
    /**
     * 创建配置类,不需要重复创建 Configuration 实例； 它的代价很高，尤其是会丢失缓存。Configuration 实例就是应用级别的单例。
     */
    private Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    public String getData(String filePath, Map<String,Object> input) throws Exception {
        StringWriter writer = new StringWriter();
        // 设置类加载机制加载模板，这里可以参考http://freemarker.foofun.cn/pgui_config_templateloading.html的内容，这是用的第二种方法。
        cfg.setClassForTemplateLoading(this.getClass(),"/");
        // 设置字符集
        cfg.setDefaultEncoding("UTF-8");
        // 加载模板
        Template template = cfg.getTemplate(filePath);
        // 合并模板和数据模型形成静态化内容
        template.process(input,writer);
        String content = writer.toString();
        // 格式化Json
        JSONObject jo_str = JSONObject.parseObject(content);
        String responseData = JSON.toJSONString(jo_str, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        return responseData;
    }
    public String getData1(String filePath, Map<String, Object> input) throws Exception {
        StringWriter writer = new StringWriter();
        // 设置类加载机制加载模板，这里可以参考http://freemarker.foofun.cn/pgui_config_templateloading.html的内容，这是用的第二种方法。
        cfg.setClassForTemplateLoading(this.getClass(),"/");
        // 设置字符集
        cfg.setDefaultEncoding("UTF-8");
        // 加载模板
        Template template = cfg.getTemplate(filePath);
        // 合并模板和数据模型形成静态化内容
        template.process(input,writer);
        String content = writer.toString();
        return content;
    }
}
