package org.codingmatters.jee.test.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codingmatters.jee.test.servlet.mocks.MockHttpServletRequest;
import org.junit.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/06/13
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class ServletTest {

    static private Tomcat server;
    static private EchoServlet servlet;
    
    private ObjectMapper mapper;
    private HttpClient client;
    
    
    
    @Before
    public void setUp() throws Exception {
        
        this.mapper = new ObjectMapper() ;
        this.client = new DefaultHttpClient() ;
    }

    @BeforeClass
    static public void setupServer() throws LifecycleException {
        server = new Tomcat();
        server.setPort(9999);

        Context ctx = server.addContext("/", MockHttpServletRequest.TRANSLATION_PATH);

        servlet = new EchoServlet() ;
        Tomcat.addServlet(ctx, "test", servlet);

        ctx.addServletMapping("/*", "test");

        server.start();
    }
    
    @AfterClass
    static public void teardownServer() throws LifecycleException {
        server.stop();
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testGet() throws Exception {
        HttpRequestBuilder requestBuilder = HttpRequestBuilder.get("localhost:9999") ;
        
        Map<String, Object> expected = this.executedRequestContent(requestBuilder);
        HashMap<String, Object> actual = EchoServlet.responseAsJSON(requestBuilder.build());
        
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPath() throws Exception {
        HttpRequestBuilder requestBuilder = HttpRequestBuilder.get("localhost:9999").path("/a/b/c") ;

        Map<String, Object> expected = this.executedRequestContent(requestBuilder);
        HashMap<String, Object> actual = EchoServlet.responseAsJSON(requestBuilder.build());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetPathWithTrailingSlash() throws Exception {
        HttpRequestBuilder requestBuilder = HttpRequestBuilder.get("localhost:9999").path("/a/b/c/") ;

        Map<String, Object> expected = this.executedRequestContent(requestBuilder);
        HashMap<String, Object> actual = EchoServlet.responseAsJSON(requestBuilder.build());
        Assert.assertEquals(expected, actual);

    }
    
    @Ignore
    @Test
    public void testGetWithOneParam() throws Exception {
        HttpRequestBuilder requestBuilder = HttpRequestBuilder.get("localhost:9999").param("name", "value") ;

        Map<String, Object> expected = this.executedRequestContent(requestBuilder);
        HashMap<String, Object> actual = EchoServlet.responseAsJSON(requestBuilder.build());
        Assert.assertEquals(expected, actual);

    }

    private Map executedRequestContent(HttpRequestBuilder requestBuilder) throws Exception {
        return this.asJsonMap(this.getContentAsString(this.executeRequest(requestBuilder)));
    }

    private HttpResponse executeRequest(HttpRequestBuilder requestBuilder) throws Exception {
        HttpResponse httpResponse = requestBuilder.execute(this.client) ;
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
        return httpResponse;
    }

    private Map asJsonMap(String content) throws IOException {
        return this.mapper.readValue(content, Map.class) ;
    }

    private String getContentAsString(HttpResponse httpResponse) throws IOException {
        StringBuilder result = new StringBuilder() ;
        char[] buffer = new char[256] ;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"))) {
            while(br.read(buffer) != -1) {
                result.append(buffer) ;
            }
        }
        return result.toString() ;
    }
}
