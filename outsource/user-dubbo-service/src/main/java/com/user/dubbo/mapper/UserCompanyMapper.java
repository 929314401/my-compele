package com.user.dubbo.mapper;

import com.user.dubbo.dto.UserCompany;
import com.user.dubbo.dto.UserCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCompanyMapper {
    int countByExample(UserCompanyExample example);

    int deleteByExample(UserCompanyExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserCompany record);

    int insertSelective(UserCompany record);

    List<UserCompany> selectByExample(UserCompanyExample example);

    UserCompany selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserCompany record, @Param("example") UserCompanyExample example);

    int updateByExample(@Param("record") UserCompany record, @Param("example") UserCompanyExample example);

    int updateByPrimaryKeySelective(UserCompany record);

    int updateByPrimaryKey(UserCompany record);
}