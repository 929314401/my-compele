package com.company.edge.response;

import com.user.dubbo.dto.User;

public class UserResponse<T> extends LoginResponse
{
    public UserResponse(String token, T instant) {
        super(token);
        this.instant = instant;
    }


    private T instant;
    public UserResponse(String token) {
        super(token);
    }

    public void setInstant(T instant) {
        this.instant = instant;
    }

    public T getInstant() {

        return instant;
    }


}
