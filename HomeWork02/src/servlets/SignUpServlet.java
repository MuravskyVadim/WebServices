package servlets;

import inteface.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;
    private static final String TEXT_HTML = "text/html";
    private static final String CHARSET_UTF_8 = "charset=utf-8";

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        accountService.singUp(login, password);

        response.setContentType(TEXT_HTML + File.pathSeparator + CHARSET_UTF_8);
        response.getWriter().println("SignedUp");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
