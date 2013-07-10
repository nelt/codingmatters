package org.codingmatters.jee.test.servlet.mocks;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

/**
* Created with IntelliJ IDEA.
* User: nel
* Date: 10/07/13
* Time: 02:25
* To change this template use File | Settings | File Templates.
*/
public class MockHttpServletRequest implements HttpServletRequest {

    public static final String TRANSLATION_PATH = new File(".").getAbsolutePath();
    static private Enumeration<String> empty = new Enumeration<String>() {
        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public String nextElement() {
            throw new NoSuchElementException() ;
        }
    } ;

    private String authType;
    private Cookie[] cookies;
    private final String method;
    private HashMap<String, List<String>> headers = new HashMap<>() ;
    private String pathInfo;
    private String path;

    public MockHttpServletRequest(String method) {
        this.method = method;
    }

    @Override
    public String getAuthType() {
        return this.authType;
    }

    @Override
    public Cookie[] getCookies() {
        return this.cookies;
    }

    @Override
    public long getDateHeader(String s) {
        try {
            return this.hasHeader(s) ? Long.parseLong(this.getHeader(s)) : -1 ;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(e) ;
        }
    }

    @Override
    public String getHeader(String s) {
        return this.hasHeader(s) ? this.headers.get(s).get(0) : null ;
    }

    private boolean hasHeader(String s) {
        return this.headers.containsKey(s) && ! this.headers.get(s).isEmpty();
    }


    @Override
    public Enumeration<String> getHeaders(String s) {
        return this.hasHeader(s) ? new IteratorEnumeration<String>(this.headers.get(s).iterator()) : empty ;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return new IteratorEnumeration<String>(this.headers.keySet().iterator()) ;
    }

    @Override
    public int getIntHeader(String s) {
        return this.hasHeader(s) ? Integer.parseInt(this.getHeader(s)) : -1;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getPathInfo() {
        return this.path;
    }

    @Override
    public String getPathTranslated() {
        return TRANSLATION_PATH + this.path;
    }

    @Override
    public String getContextPath() {
        return "";
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

    public MockHttpServletRequest header(String name, String value) {
        if(! this.headers.containsKey(name)) {
            this.headers.put(name, new ArrayList<String>()) ;
        }
        this.headers.get(name).add(value);
        return this ;
    }

    public MockHttpServletRequest path(String path) {
        this.path = path ;
        return this ;
    }
}
