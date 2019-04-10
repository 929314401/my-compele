package com.project.dubbo.mapper;

import com.project.dubbo.dto.PjInformation;
import com.project.dubbo.dto.PjInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PjInformationMapper {
    int countByExample(PjInformationExample example);

    int deleteByExample(PjInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PjInformation record);

    int insertSelective(PjInformation record);

    List<PjInformation> selectByExample(PjInformationExample example);

    PjInformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PjInformation record, @Param("example") PjInformationExample example);

    int updateByExample(@Param("record") PjInformation record, @Param("example") PjInformationExample example);

    int updateByPrimaryKeySelective(PjInformation record);

    int updateByPrimaryKey(PjInformation record);
}