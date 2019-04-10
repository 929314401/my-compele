package com.studio.work.dubbo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class StudioAll implements Serializable {

    private WorkStudio workStudio;

    private List<String> images;

    public void setWorkStudio(WorkStudio workStudio) {
        this.workStudio = workStudio;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public WorkStudio getWorkStudio() {

        return workStudio;
    }

    public List<String> getImages() {
        return images;
    }
}
