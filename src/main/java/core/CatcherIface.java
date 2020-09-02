package core;

import common.URLConnectionResult;
import core.Impl.Catcher;

import java.net.HttpURLConnection;

public interface CatcherIface {

    Catcher get(String url);

    Catcher post(String url);

    Catcher addData(String data);

    Catcher addHeader(String key,String val);

    String catchContent();



}
