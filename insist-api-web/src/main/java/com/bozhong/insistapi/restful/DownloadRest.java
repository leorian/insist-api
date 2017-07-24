package com.bozhong.insistapi.restful;

import com.bozhong.insistapi.util.DownUtil;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebServletContext;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.util.UUID;

/**
 * Created by xiezg@317hu.com on 2017/7/24 0024.
 */
@Controller
@Singleton
@Path("download")
public class DownloadRest {
    /**
     * http://localhost:8080/rest/download/exportApi.pdf
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     */
    @GET
    @Path("exportApi.pdf")
    public void findInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        String appId = (String) EWebServletContext.getEWebContext().get("appId");
        String requestUrl = EWebServletContext.getRequest().getRequestURL().toString();
        requestUrl = requestUrl.replaceAll("rest/download/exportApi.pdf", "admin/pdf.htm?appId=" + appId);
        String filePath = System.getProperty("openOffice.storage") + File.separator + UUID.randomUUID().toString() + ".pdf";
        if (!new File(filePath).exists()) {
            new File(filePath).getParentFile().mkdirs();
        }
        DownUtil.wkHtmlToPdf(requestUrl,filePath);
        try {
            DownUtil.downLoad(filePath,EWebServletContext.getResponse(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
