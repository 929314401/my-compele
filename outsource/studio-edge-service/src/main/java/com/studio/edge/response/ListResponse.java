package com.studio.edge.response;

import java.util.List;

public class ListResponse<T> extends LoginResponse {
    private List<T> listResult;
    public ListResponse(String token) {
        super(token);
    }

    public ListResponse(String token, List<T> listResult) {
        super(token);
        this.listResult = listResult;
    }

    public void setListResult(List<T> listResult) {

        this.listResult = listResult;
    }

    public List<T> getListResult() {

        return listResult;
    }
}
