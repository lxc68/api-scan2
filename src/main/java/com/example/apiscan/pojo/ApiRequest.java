package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 16:36
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequest {
    private String name;
    private Request request;
}
