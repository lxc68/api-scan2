package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: wenfeng
 * @Date: 2022/07/27 16:18
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private Info info;
    private List<ApiRequest> apiRequests;
}
