package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        String httpVersion = req.getProtocol();
        String scheme = req.getScheme();

        System.out.println("httpMethod = " + httpMethod);
        System.out.println("httpVersion = " + httpVersion);
        System.out.println("scheme = " + scheme);

        StringBuffer requestURL = req.getRequestURL();
        String requestURI = req.getRequestURI();

        System.out.println("requestURI = " + requestURI);
        System.out.println("requestURL = " + requestURL);
    }
}
