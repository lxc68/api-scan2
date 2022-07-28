package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 17:00
 * @version: IT2022
 * @Description: 请求的参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private String key;
    private String value;
}
