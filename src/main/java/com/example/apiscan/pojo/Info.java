package com.example.apiscan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: wenfeng
 * @Date: 2022/07/28 11:16
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
public class Info {
    private String _postman_id;
    private String name;
    private String schema;
    private String _exporter_id;
}
