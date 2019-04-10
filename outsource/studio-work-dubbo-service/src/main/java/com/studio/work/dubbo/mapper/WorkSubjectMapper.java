package com.studio.work.dubbo.mapper;

import com.studio.work.dubbo.dto.WorkSubject;
import com.studio.work.dubbo.dto.WorkSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkSubjectMapper {
    int countByExample(WorkSubjectExample example);

    int deleteByExample(WorkSubjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkSubject record);

    int insertSelective(WorkSubject record);

    List<WorkSubject> selectByExample(WorkSubjectExample example);

    WorkSubject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkSubject record, @Param("example") WorkSubjectExample example);

    int updateByExample(@Param("record") WorkSubject record, @Param("example") WorkSubjectExample example);

    int updateByPrimaryKeySelective(WorkSubject record);

    int updateByPrimaryKey(WorkSubject record);
}