package org.codingmatters.jee.test.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.codingmatters.jee.test.servlet.internal.Method;
import org.codingmatters.jee.test.servlet.mocks.MockHttpServletRequest;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 01/07/13
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestBuilder {

    private static final String USERAGENT = "CodingMatters-RequestBuilder" ;
    
    private final String address;
    private final Method method;
    private String path;

    public static HttpRequestBuilder get(String address) {
        return new HttpRequestBuilder(address, Method.GET).path("") ;
    }
    
    private HttpRequestBuilder(String address, Method method) {
        this.address = address;
        this.method = method;
    }
    
    public HttpRequestBuilder path(String path) {
        this.path = path ;
        return this ;
    }
    
    public HttpResponse execute(HttpClient client) throws Exception {

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost(this.address)
                .setPath(this.getPath())
                ;
        
        for (String name : this.params.keySet()) {
            for (String value : this.params.get(name)) {
                uriBuilder.setParameter(name, value) ;
            }
        }


        HttpUriRequest request = this.method.request(uriBuilder.build().toString());
        request.setHeader("user-agent", USERAGENT );
        
        return client.execute(request) ;
    }

    public HttpServletRequest build() {
        MockHttpServletRequest result = new MockHttpServletRequest(this.method.toString());

        result
                .header("connection", "Keep-Alive")
                .header("host", this.getHost())
                .header("user-agent", USERAGENT)
        ;

        result.path(this.getPath());

        for (String name : this.params.keySet()) {
            result.parameter(name, this.params.get(name)) ;
        }


        return result;
    }

    public String getHost() {
        return this.address;
    }

    public String getPath() {
        return this.path.startsWith("/") ? this.path : "/" + this.path ;
    }
    
    private final HashMap<String, ArrayList<String>> params = new HashMap<>() ;
    
    public HttpRequestBuilder param(String name, String value) {
        if(! this.params.containsKey(name)) {
            this.params.put(name, new ArrayList<String>()) ;
        }
        this.params.get(name).add(value) ;
        return this ;
    }
}
