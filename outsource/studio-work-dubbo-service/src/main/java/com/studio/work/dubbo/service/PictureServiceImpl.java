package com.studio.work.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.studio.work.dubbo.dto.PictrueStudio;
import com.studio.work.dubbo.dto.PictrueStudioExample;
import com.studio.work.dubbo.mapper.PictrueStudioMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureStudioService {

    @Autowired
    private PictrueStudioMapper pictrueStudioMapper;

    @Override
    public List<PictrueStudio> selectByPid(Integer pid) {
        PictrueStudioExample example=new PictrueStudioExample();
        PictrueStudioExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        return pictrueStudioMapper.selectByExample(example);
    }

    @Override
    public void removeById(Integer id) {
        pictrueStudioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertByPic(PictrueStudio pictrueStudio) {
        pictrueStudioMapper.insert(pictrueStudio);
    }
}
