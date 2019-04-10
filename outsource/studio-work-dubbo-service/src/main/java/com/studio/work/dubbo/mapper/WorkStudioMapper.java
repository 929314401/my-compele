package com.studio.work.dubbo.mapper;

import com.studio.work.dubbo.dto.WorkStudio;
import com.studio.work.dubbo.dto.WorkStudioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkStudioMapper {
    int countByExample(WorkStudioExample example);

    int deleteByExample(WorkStudioExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkStudio record);

    int insertSelective(WorkStudio record);

    List<WorkStudio> selectByExample(WorkStudioExample example);

    WorkStudio selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkStudio record, @Param("example") WorkStudioExample example);

    int updateByExample(@Param("record") WorkStudio record, @Param("example") WorkStudioExample example);

    int updateByPrimaryKeySelective(WorkStudio record);

    int updateByPrimaryKey(WorkStudio record);
}