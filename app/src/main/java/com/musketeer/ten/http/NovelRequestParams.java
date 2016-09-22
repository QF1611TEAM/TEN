package com.musketeer.ten.http;

import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

/**
 * 网络请求的参数实体
 * Created by Hey on 2016/9/12.
 */
@HttpRequest(host = "http://api.shigeten.net", path = "api/Novel/GetNovelContent")
public class NovelRequestParams extends RequestParams {
    public int id;
}
