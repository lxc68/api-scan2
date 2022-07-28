package com.example.apiscan.testfreemarker;

import com.example.apiscan.pojo.Info;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: wenfeng
 * @Date: 2022/07/28 11:38
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
public class Order {
    public String orderNumber;
    public Info info;
    public List<OrderLine> lines;
}
