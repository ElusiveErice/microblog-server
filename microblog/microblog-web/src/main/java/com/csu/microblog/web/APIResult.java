package com.csu.microblog.web;

public class APIResult {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static APIResult okResult(){
        return createResult(0, null);
    }

    public static APIResult createOkResult(Object data){
        return createResult(0, data);
    }

    public static APIResult createResult(int code, Object data){
        switch (code){
            case 0:
                return createResult(0,"ok", data);
            default:
                return createResult(0,"",data);
        }
    }

    public static APIResult createResult(int code, String message, Object data){
        APIResult apiResult = new APIResult();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        apiResult.setData(data);
        return apiResult;
    }
}
