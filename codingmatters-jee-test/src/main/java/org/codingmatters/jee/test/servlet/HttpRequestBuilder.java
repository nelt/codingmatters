package org.codingmatters.jee.test.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.codingmatters.jee.test.servlet.internal.Method;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 01/07/13
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestBuilder {

    private final String url;
    private final Method method;

    public static HttpRequestBuilder get(String url) {
        return new HttpRequestBuilder(url, Method.GET) ;
    }
    
    private HttpRequestBuilder(String url, Method method) {

        this.url = url;
        this.method = method;
    }
    
    public HttpResponse execute(HttpClient client) throws IOException {
        HttpUriRequest request = this.method.request(this.url) ;
        return client.execute(request) ;
    }
    
    public HttpServletRequest build() {
        return new HttpServletRequest() {
            @Override
            public String getAuthType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Cookie[] getCookies() {
                return new Cookie[0];  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public long getDateHeader(String s) {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getHeader(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Enumeration<String> getHeaders(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Enumeration<String> getHeaderNames() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getIntHeader(String s) {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getMethod() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getPathInfo() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getPathTranslated() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getContextPath() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getQueryString() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRemoteUser() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Principal getUserPrincipal() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRequestedSessionId() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRequestURI() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public StringBuffer getRequestURL() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getServletPath() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public HttpSession getSession(boolean b) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public HttpSession getSession() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isRequestedSessionIdValid() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isRequestedSessionIdFromCookie() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isRequestedSessionIdFromURL() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isRequestedSessionIdFromUrl() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void login(String s, String s2) throws ServletException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void logout() throws ServletException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Part getPart(String s) throws IOException, IllegalStateException, ServletException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Object getAttribute(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getCharacterEncoding() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getContentLength() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getContentType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public ServletInputStream getInputStream() throws IOException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getParameter(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Enumeration<String> getParameterNames() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String[] getParameterValues(String s) {
                return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Map<String, String[]> getParameterMap() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getProtocol() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getScheme() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getServerName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getServerPort() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public BufferedReader getReader() throws IOException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRemoteAddr() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRemoteHost() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void setAttribute(String s, Object o) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void removeAttribute(String s) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Locale getLocale() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public Enumeration<Locale> getLocales() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isSecure() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public RequestDispatcher getRequestDispatcher(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getRealPath(String s) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getRemotePort() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getLocalName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getLocalAddr() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getLocalPort() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public ServletContext getServletContext() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public AsyncContext startAsync() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isAsyncStarted() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public boolean isAsyncSupported() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public AsyncContext getAsyncContext() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public DispatcherType getDispatcherType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        } ;
    }
}
