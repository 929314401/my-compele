package com.user.dubbo.mapper;

import com.user.dubbo.dto.UserStudio;
import com.user.dubbo.dto.UserStudioExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface UserStudioMapper {
    int countByExample(UserStudioExample example);

    int deleteByExample(UserStudioExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserStudio record);

    int insertSelective(UserStudio record);

    List<UserStudio> selectByExample(UserStudioExample example);

    UserStudio selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserStudio record, @Param("example") UserStudioExample example);

    int updateByExample(@Param("record") UserStudio record, @Param("example") UserStudioExample example);

    int updateByPrimaryKeySelective(UserStudio record);

    int updateByPrimaryKey(UserStudio record);



}