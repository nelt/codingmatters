package org.codingmatters.jee.test.servlet.internal;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 01/07/13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public enum Method {
    GET {
        @Override
        public HttpUriRequest request(String url) {
            return new HttpGet(url) ;
        }
    };

    public abstract HttpUriRequest request(String url) ;

}
