package com.project.dubbo.dto;

import com.project.dubbo.dto.StudioApply;

import java.io.Serializable;

public class StartStudio  implements Serializable {
    private Integer star;

    private StudioApply apply;

    public StartStudio() {
    }

    public StartStudio(Integer star, StudioApply apply) {
        this.star = star;
        this.apply = apply;
    }

    public void setApply(StudioApply apply) {

        this.apply = apply;
    }

    public StudioApply getApply() {

        return apply;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getStar() {

        return star;
    }

    public StartStudio(Integer star) {

        this.star = star;
    }
}
