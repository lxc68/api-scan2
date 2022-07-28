package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 16:25
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private String raw;
    private String protocol;
    private String port;
    private List<String> hosts;
    private List<String> paths;
    private List<Param> querys;
}
