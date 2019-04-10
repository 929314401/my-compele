package com.user.dubbo.mapper;

import com.user.dubbo.dto.CompanyDTO;
import com.user.dubbo.dto.StudioDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AllUserMapper {


    @Select("    select a.id,a.userid,a.email,a.state,b.name,b.descb,b.registertime,b.tex,b.start" +
            " from user as a left join user_studio as b on a.id=b.user_id and id=#{id}")
    StudioDTO selectStudioDtoByid(@Param("id") Integer id);

    @Select(" select a.id,a.userid,a.email," +
            "a.state,b.name,b.message,b.registertime," +
            "b.address,b.tex,b.filed,b.number" +
            " from user as a left join " +
            "user_company as b on a.id=b.user_id and id=#{id}")
    CompanyDTO selectCompanyDTOByid(@Param("id")Integer id);
}
