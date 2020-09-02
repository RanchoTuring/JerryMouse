package core;


import common.ErrorCode;
import common.HTTPMethod;
import common.URLConnectionResult;

import java.io.*;
import java.net.*;

public class BaseOp {


    public boolean verifyUrl(String url) {
        //TODO finish
        return true;
    }


    public URL getUrl(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public URLConnectionResult getURLConnection(String urlString) {
        if (!verifyUrl(urlString)) {
            return new URLConnectionResult(ErrorCode.URL_INVALID);
        }

        URL url = getUrl(urlString);

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            return new URLConnectionResult(ErrorCode.OK, urlConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new URLConnectionResult(ErrorCode.OPEN_CONNECTION_FAILED);
    }

    public void setRequestMethod(URLConnectionResult connectionResult, HTTPMethod method) {

        HttpURLConnection connection = connectionResult.getHttpConnection();
        try {
            connection.setRequestMethod(method.getMethod());
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public String requestAndCatch(HttpURLConnection connection, String requestData) {
        try {
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(60000);

            if (!requestData.equals("")) {
                connection.setDoOutput(true);
                PrintStream ps = new PrintStream(connection.getOutputStream());
                ps.println(requestData);
                ps.close();
            }

            //request be sent when you use getInputStream()
            InputStream is = connection.getInputStream();

            if (connection.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                StringBuffer bf = new StringBuffer();
                String data = null;
                while ((data = in.readLine()) != null) {
                    bf.append(data);
                    bf.append("\n");
                }
                return bf.toString();
            } else {
                return String.format(ErrorCode.REQUEST_FAILED.getMsg(), connection.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ErrorCode.CONNECT_FAILED.getMsg();
        } finally {
            connection.disconnect();
        }

    }

}
