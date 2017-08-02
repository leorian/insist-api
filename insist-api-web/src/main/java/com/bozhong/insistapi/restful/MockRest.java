package com.bozhong.insistapi.restful;

import com.bozhong.insistapi.common.InsistApiConstants;
import com.sun.jersey.spi.resource.Singleton;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Created by xiezg@317hu.com on 2017/8/2 0002.
 */
@Controller
@Singleton
@Path(InsistApiConstants.MOCK)
public class MockRest {


    @Path("{mockAddress:[\\w\\W]*$}")
    @GET
    public String mockGet(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("mockAddress") String mockAddress) {
        return "HelloWorld Get" + mockAddress;
    }

    @Path("{mockAddress:[\\w\\W]*$}")
    @POST
    public String mockPost(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("mockAddress") String mockAddress) {
        return "HelloWorld Post" + mockAddress;
    }
}
