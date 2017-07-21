package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.domain.InterfaceHttpDomain;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/21 0021.
 */
@Controller
@Singleton
@Path("interfaceHttp")
public class InterfaceHttpRest {

    @POST
    @Path("insertInterfaceHttp")
    public String generatePublicKey(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        InterfaceHttpDomain httpDomain = new InterfaceHttpDomain();
        try {
            BeanUtils.copyProperties(httpDomain, param);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(httpDomain));
        return "";
    }
}
