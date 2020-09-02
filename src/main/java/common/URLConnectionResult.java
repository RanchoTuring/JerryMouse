package common;

import lombok.Data;

import java.net.HttpURLConnection;
import java.net.URLConnection;
@Data
public class URLConnectionResult {
    boolean isSuccess;
    int code;
    String msg;
    HttpURLConnection httpConnection;

    public URLConnectionResult(ErrorCode errorCode, HttpURLConnection connection) {
        code = errorCode.getCode();
        msg = errorCode.getMsg();
        httpConnection = connection;
        if (code == 0) {
            isSuccess = true;
        }
    }

    public URLConnectionResult(ErrorCode errorCode) {
        code = errorCode.getCode();
        msg = errorCode.getMsg();
    }
}
