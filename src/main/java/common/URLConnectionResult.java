package common;

import lombok.Data;

import java.net.URLConnection;
@Data
public class URLConnectionResult {
    boolean isSuccess;
    int code;
    String msg;
    URLConnection connection;

    public URLConnectionResult(ErrorCode errorCode, URLConnection connection) {
        code = errorCode.getCode();
        msg = errorCode.getMsg();
        this.connection = connection;
        if (code == 0) {
            isSuccess = true;
        }
    }

    public URLConnectionResult(ErrorCode errorCode) {
        code = errorCode.getCode();
        msg = errorCode.getMsg();
    }
}
