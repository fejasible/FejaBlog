package com.feja.blog.mapper;

import com.feja.blog.model.Contact;
import com.feja.blog.model.ContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactMapper {
    int countByExample(ContactExample example);

    int deleteByExample(ContactExample example);

    int deleteByPrimaryKey(Integer contactId);

    int insert(Contact record);

    int insertSelective(Contact record);

    List<Contact> selectByExampleWithBLOBs(ContactExample example);

    List<Contact> selectByExample(ContactExample example);

    Contact selectByPrimaryKey(Integer contactId);

    int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByExampleWithBLOBs(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKeyWithBLOBs(Contact record);

    int updateByPrimaryKey(Contact record);
}