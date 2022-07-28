package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 16:19
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private String method;
    private List<String> header;
    private Url url;
}
