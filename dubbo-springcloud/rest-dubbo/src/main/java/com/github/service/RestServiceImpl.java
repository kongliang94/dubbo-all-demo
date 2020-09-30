package com.github.service;

import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service(protocol = "rest")
@Path("/")
public class RestServiceImpl implements RestService {

    @Path("test/{p}")
    @GET
    public String test(@PathParam("p") String param) {
        return "rest service: " + param;
    }
}
