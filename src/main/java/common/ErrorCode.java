package common;

public enum ErrorCode {
    OK(0,"ok"),
    URL_INVALID(1,"url格式不正确"),
    OPEN_CONNECTION_FAILED(1,"打开url链接失败"),
    CONNECT_FAILED(1,"连接失败"),
    REQUEST_FAILED(1,"请求失败，http错误代码：%d");


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ErrorCode(int code, String msg){
        this.msg=msg;
    }


    int code;
    String msg;


}
