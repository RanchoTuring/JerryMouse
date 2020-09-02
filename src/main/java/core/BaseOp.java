package core;

import common.ErrorCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BaseOp {


    public boolean verifyUrl(String url){
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


    public URLConnection getURLConnection(String urlString){
        if(!verifyUrl(urlString)){
            return ErrorCode.URL_INVALID.getMsg();
        }

        URL url=baseOp.getUrl(urlStr);

        URLConnection urlConnection=url.openConnection();


    }

}
