package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(accountService.getUserByLogin(login) != null)
        {
            response.getWriter().println("Authorized: " + login);
            response.setStatus(200);
        }
        else {
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
