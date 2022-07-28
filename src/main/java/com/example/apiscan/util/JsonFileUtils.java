package com.example.apiscan.util;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 14:33
 * @version: IT2022
 * @Description: 生成Json文件
 */
@Component
public class JsonFileUtils {
    public File createJsonFile(String fileName) throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        // 拼接文件完整路径// 生成json格式文件
        String fullPath = path + File.separator + fileName + ".json";
        // 保证创建一个新文件
        File file = new File(fullPath);
        // 如果父目录不存在，创建父目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        return file;
    }
}
