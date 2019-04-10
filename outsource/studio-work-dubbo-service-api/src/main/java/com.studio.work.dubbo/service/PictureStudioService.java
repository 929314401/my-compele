package com.studio.work.dubbo.service;

import com.studio.work.dubbo.dto.PictrueStudio;

import java.util.List;

public interface PictureStudioService {
    List<PictrueStudio> selectByPid(Integer pid);
    void removeById(Integer id);
    void insertByPic(PictrueStudio pictrueStudio);
}
