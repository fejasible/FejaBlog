package com.feja.blog.mapper;

import com.feja.blog.model.Config;
import com.feja.blog.model.ConfigExample;
import com.feja.blog.model.ConfigWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigMapper {
    int countByExample(ConfigExample example);

    int deleteByExample(ConfigExample example);

    int deleteByPrimaryKey(Integer configId);

    int insert(ConfigWithBLOBs record);

    int insertSelective(ConfigWithBLOBs record);

    List<ConfigWithBLOBs> selectByExampleWithBLOBs(ConfigExample example);

    List<Config> selectByExample(ConfigExample example);

    ConfigWithBLOBs selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") ConfigWithBLOBs record, @Param("example") ConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") ConfigWithBLOBs record, @Param("example") ConfigExample example);

    int updateByExample(@Param("record") Config record, @Param("example") ConfigExample example);

    int updateByPrimaryKeySelective(ConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConfigWithBLOBs record);

    int updateByPrimaryKey(Config record);
}