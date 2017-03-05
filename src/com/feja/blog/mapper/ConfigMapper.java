package com.feja.blog.mapper;

import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigWithBLOBs;

public interface ConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(ConfigWithBLOBs record);

    int insertSelective(ConfigWithBLOBs record);

    ConfigWithBLOBs selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(ConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConfigWithBLOBs record);

    int updateByPrimaryKey(Config record);
}