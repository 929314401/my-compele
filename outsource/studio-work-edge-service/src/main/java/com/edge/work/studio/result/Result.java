package com.edge.work.studio.result;

public class Result {
    private String code;
    private String message;

    public Result() {
        this("0","success");
    }

    public Result(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }
    public static Result exception(Exception e){
        return new Result("9999",e.getMessage());
    }

}
