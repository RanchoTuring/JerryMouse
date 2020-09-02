package core.Impl;

import common.HTTPMethod;
import common.URLConnectionResult;
import core.BaseOp;
import core.CatcherIface;
import lombok.Data;

@Data
public class Catcher implements CatcherIface {

    BaseOp baseOp = new BaseOp();
    StringBuffer dataBuf=new StringBuffer();
    URLConnectionResult connectionResult;

    @Override
    public Catcher get(String urlStr) {
        URLConnectionResult result = baseOp.getURLConnection(urlStr);

        if (result.isSuccess()) {
            baseOp.setRequestMethod(result, HTTPMethod.GET);
        }

        this.setConnectionResult(result);
        return this;
    }

    @Override
    public Catcher post(String urlStr) {
        URLConnectionResult result = baseOp.getURLConnection(urlStr);

        if (result.isSuccess()) {
            baseOp.setRequestMethod(result, HTTPMethod.POST);
        }

        this.setConnectionResult(result);
        return this;
    }

    @Override
    public Catcher addHeader(String key, String val) {
        connectionResult.getHttpConnection().addRequestProperty(key,val);
        return this;
    }

    @Override
    public Catcher addData(String data) {
        dataBuf.append(data);
        return this;
    }

    @Override
    public String catchContent() {
        return baseOp.requestAndCatch(connectionResult.getHttpConnection(),dataBuf.toString());
    }
}
