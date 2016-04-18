package net.xwdoor.remoteservice.mockdata;

import android.content.Context;

import net.xwdoor.remoteservice.net.Response;

/**
 * Created by XWdoor on 2016/4/18 018 10:23.
 * 博客：http://blog.csdn.net/xwdoor
 */
public abstract class MockService {

//    protected final Gson gson;
//
//    public MockService() {
//        gson = new Gson();
//    }

    public abstract String getJsonData(Context context);

    protected Response getSuccessResponse() {
        Response response = new Response();

        response.setCode(0);
        response.setError("");

        return response;
    }

    protected Response getFailResponse(int errorType, String errorMessage) {
        Response response = new Response();
        response.setCode(errorType);
        response.setError(errorMessage);

        return response;
    }
}