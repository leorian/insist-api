package com.bozhong.insistapi.task;

import com.alibaba.fastjson.JSON;
import com.bozhong.config.common.ConfigSetPropertyHolder;
import com.bozhong.insistapi.entity.AppDO;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;


/**
 * Created by xiezhonggui on 2017/5/4.
 */
public class DocHttpUtil {

    /**
     * 从配置中心获取用户的应用ID
     *
     * @param uId
     * @return
     */
    public static List<AppDO> getAppDOList(String uId) throws IOException {
        HttpClient client = new HttpClient(new HttpClientParams(),
                new SimpleHttpConnectionManager(true));
        PostMethod method = new PostMethod(ConfigSetPropertyHolder.CONFIG_CENTER_URL
                + "/config/configSet/loadAppDOList");
        NameValuePair appKeyNVP = new NameValuePair("appKey", ConfigSetPropertyHolder.CONFIG_CENTER_ACCESS_KEY);
        NameValuePair uIdNVP = new NameValuePair("uId", uId);
        method.setRequestBody(new NameValuePair[]{appKeyNVP, uIdNVP});
        try {
            client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = new String(IOUtils.toByteArray(method.getResponseBodyAsStream()), "utf-8");
        return JSON.parseArray(response, AppDO.class);
    }
}
