package servlets;

import inteface.AccountService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        accountService.singUp(login, password);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("SignedUp");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
