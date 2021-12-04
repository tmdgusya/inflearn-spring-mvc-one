package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

        content(resp);

        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        cookie(resp);

        resp.getWriter().write("OK");
    }

    private void content(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("text/plain");
        httpServletResponse.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("myCookie", "isGood");
        cookie.setMaxAge(600);
        httpServletResponse.addCookie(cookie);
    }

}
