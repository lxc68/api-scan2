package com.example.apiscan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 11:16
 * @version: IT2022
 * @Description:
 */
@Data
@TableName("api_url")
public class ApiUrlDo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String url;
    private String methodName;
}
