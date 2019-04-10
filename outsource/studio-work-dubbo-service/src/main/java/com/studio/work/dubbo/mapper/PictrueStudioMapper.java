package com.studio.work.dubbo.mapper;

import com.studio.work.dubbo.dto.PictrueStudio;
import com.studio.work.dubbo.dto.PictrueStudioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictrueStudioMapper {
    int countByExample(PictrueStudioExample example);

    int deleteByExample(PictrueStudioExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PictrueStudio record);

    int insertSelective(PictrueStudio record);

    List<PictrueStudio> selectByExample(PictrueStudioExample example);

    PictrueStudio selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PictrueStudio record, @Param("example") PictrueStudioExample example);

    int updateByExample(@Param("record") PictrueStudio record, @Param("example") PictrueStudioExample example);

    int updateByPrimaryKeySelective(PictrueStudio record);

    int updateByPrimaryKey(PictrueStudio record);
}