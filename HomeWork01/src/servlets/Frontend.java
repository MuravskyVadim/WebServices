package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Frontend extends HttpServlet {
    private static final String TEXT_HTML = "text/html";
    private static final String CHARSET_UTF_8 = "charset=utf-8";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String value = request.getParameter("key");

        if (value != null) {
            response.getWriter().println(value);
        }
        response.setContentType(TEXT_HTML + File.pathSeparator + CHARSET_UTF_8);
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
