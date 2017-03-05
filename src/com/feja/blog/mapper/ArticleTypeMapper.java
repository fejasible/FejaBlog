package com.feja.blog.mapper;

import com.feja.blog.model.ArticleType;
import com.feja.blog.model.ArticleTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleTypeMapper {
    int countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}