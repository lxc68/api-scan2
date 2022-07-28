package com.example.apiscan.testfreemarker;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: wenfeng
 * @Date: 2022/07/28 11:38
 * @version: IT2022
 * @Description:
 */
@Data
@AllArgsConstructor
public class OrderLine {
    public String unit;
    public Integer quantity;
    public String itemNumber;
}
