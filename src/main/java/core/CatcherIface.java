package core;

import core.Impl.Catcher;

public interface CatcherIface {

    CatcherIface get(String url);

    CatcherIface post(String url);

    CatcherIface addData(String data);

    CatcherIface addHeader(String key, String val);

    String catchContent();

    String catchAndOutput(String path, String fileName);


}
