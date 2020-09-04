package common;

/**
 * http请求方法枚举类
 */
public enum HTTPMethod {
    GET("GET"),
    POST("POST");

    HTTPMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    String method;
}
