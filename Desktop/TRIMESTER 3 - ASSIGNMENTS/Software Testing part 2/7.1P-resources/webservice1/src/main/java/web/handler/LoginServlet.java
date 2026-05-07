package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * Ayush Indapure - 224880003
 * Handles /login requests
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        boolean isValid = LoginService.login(username, password, dob);

        String status = isValid ? "success" : "fail";

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>" + status + "</title></head>");
        out.println("<body>");
        out.println("<h2>Login Status: " + status + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}