package org.codingmatters.jee.test.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.codingmatters.jee.test.servlet.internal.Method;
import org.codingmatters.jee.test.servlet.mocks.MockHttpServletRequest;

import javax.servlet.http.*;
import java.io.IOException;

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
    
    public HttpResponse execute(HttpClient client) throws IOException {
        HttpUriRequest request = this.method.request("http://" + this.address + this.getPath()) ;
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
        
        return result;
    }

    public String getHost() {
        return this.address;
    }

    public String getPath() {
        return this.path.startsWith("/") ? this.path : "/" + this.path ;
    }
}
