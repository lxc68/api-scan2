package com.example.apiscan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apiscan.pojo.ApiUrlDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wenfeng
 * @Date: 2022/07/26 11:29
 * @version: IT2022
 * @Description:
 */
@Mapper
public interface ApiUrlDao extends BaseMapper<ApiUrlDo> {

    /**
     * 查询所有的api
     * @return
     */
    @Select("select * from api_url")
    List<ApiUrlDo> getAll();

    /**
     * 新增
     * @param apiUrlDo
     * @return
     */
    @Override
    @Insert("insert into api_url (url,methodName) values(#{url},#{methodName})")
    int	insert(ApiUrlDo apiUrlDo);

    /**
     * 根据path查询
     * @param url
     * @return
     */
    @Select("select * from api_url where url = #{url}")
    ApiUrlDo selectByPath(String url);
}
