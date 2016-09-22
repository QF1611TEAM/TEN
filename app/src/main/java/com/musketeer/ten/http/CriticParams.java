package com.musketeer.ten.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * Created by Kevin on 2016/9/21.
 *critic下边接口
 *
 * http://api.shigeten.net/api/Critic/GetCriticContent?id=100035
 */
@HttpRequest(host = "http://api.shigeten.net",path = "api/Critic/GetCriticContent")
public class CriticParams extends RequestParams {

    public String id;

}
