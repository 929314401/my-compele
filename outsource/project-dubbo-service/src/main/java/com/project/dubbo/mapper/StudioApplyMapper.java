package com.project.dubbo.mapper;

import com.project.dubbo.dto.StudioApply;
import com.project.dubbo.dto.StudioApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudioApplyMapper {
    int countByExample(StudioApplyExample example);

    int deleteByExample(StudioApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudioApply record);

    int insertSelective(StudioApply record);

    List<StudioApply> selectByExample(StudioApplyExample example);

    StudioApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudioApply record, @Param("example") StudioApplyExample example);

    int updateByExample(@Param("record") StudioApply record, @Param("example") StudioApplyExample example);

    int updateByPrimaryKeySelective(StudioApply record);

    int updateByPrimaryKey(StudioApply record);
}