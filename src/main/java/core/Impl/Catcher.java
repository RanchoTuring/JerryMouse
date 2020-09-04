package core.Impl;

import common.HTTPMethod;
import common.URLConnectionResult;
import core.BaseOp;
import core.CatcherIface;


public class Catcher implements CatcherIface {

    private BaseOp baseOp = new BaseOp();
    private StringBuffer dataBuf = new StringBuffer();
    private URLConnectionResult connectionResult;

    @Override
    public Catcher get(String urlStr) {
        URLConnectionResult result = baseOp.getURLConnection(urlStr);

        if (result.isSuccess()) {
            baseOp.setRequestMethod(result, HTTPMethod.GET);
        }

        connectionResult = result;
        return this;
    }

    @Override
    public Catcher post(String urlStr) {
        URLConnectionResult result = baseOp.getURLConnection(urlStr);

        if (result.isSuccess()) {
            baseOp.setRequestMethod(result, HTTPMethod.POST);
        }

        connectionResult = result;
        return this;
    }

    @Override
    public Catcher addHeader(String key, String val) {
        connectionResult.getHttpConnection().addRequestProperty(key, val);
        return this;
    }

    @Override
    public Catcher addData(String data) {
        dataBuf.append(data);
        return this;
    }

    @Override
    public String catchContent() {
        return baseOp.requestAndCatch(connectionResult.getHttpConnection(), dataBuf.toString());
    }

    @Override
    public String catchAndOutput(String path, String fileName) {
        return null;
    }
}
