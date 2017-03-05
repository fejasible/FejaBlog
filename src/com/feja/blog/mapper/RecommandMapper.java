package com.feja.blog.mapper;

import com.feja.blog.model.Recommand;

public interface RecommandMapper {
    int deleteByPrimaryKey(Integer recomandId);

    int insert(Recommand record);

    int insertSelective(Recommand record);

    Recommand selectByPrimaryKey(Integer recomandId);

    int updateByPrimaryKeySelective(Recommand record);

    int updateByPrimaryKey(Recommand record);
}