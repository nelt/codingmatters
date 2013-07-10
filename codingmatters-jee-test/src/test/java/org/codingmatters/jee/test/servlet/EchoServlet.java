package org.codingmatters.jee.test.servlet;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/06/13
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name="echo", urlPatterns={"/echo"})
public class EchoServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper() ;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        this.writeResponse(responseAsJSON(req), resp.getWriter());
    }

    static public HashMap<String, Object> responseAsJSON(HttpServletRequest req) {
        HashMap<String, Object> json = new HashMap<>() ;
        json.put("AuthType", req.getAuthType()) ;
        json.put("ContextPath", req.getContextPath()) ;
        json.put("Method", req.getMethod()) ;
        json.put("Headers", headearsAsJSON(req)) ;
        json.put("PathInfo", req.getPathInfo()) ;
        json.put("PathTranslated", req.getPathTranslated()) ;
        json.put("Cookies", req.getCookies()) ;
        json.put("Parameters", req.getParameterMap()) ;
        return json;
    }

    static private Object headearsAsJSON(HttpServletRequest req) {
        HashMap<String, Object> json = new HashMap<>() ;
        Enumeration<String> names = req.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            ArrayList<String> namedHeaders = new ArrayList<>() ;
            Enumeration<String> headers = req.getHeaders(name);
            while(headers.hasMoreElements()) {
                namedHeaders.add(headers.nextElement()) ;
            }
            json.put(name, namedHeaders) ;
        }
        return json;
    }

    private synchronized void writeResponse(Object json, PrintWriter writer) throws IOException {
        writer.write(mapper.writeValueAsString(json));
    }


}
