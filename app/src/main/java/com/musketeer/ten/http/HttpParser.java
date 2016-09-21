package com.musketeer.ten.http;

import com.google.gson.Gson;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * Created by Kevin on 2016/9/21.
 */
public class HttpParser implements ResponseParser{

    @Override
    public void checkResponse(UriRequest request) throws Throwable {
    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result,resultClass);
    }
}
