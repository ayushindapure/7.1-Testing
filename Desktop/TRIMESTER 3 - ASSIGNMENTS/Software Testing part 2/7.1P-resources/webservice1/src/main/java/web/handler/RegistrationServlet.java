package web.handler;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * Ayush Indapure - 224880003
 * Handles /reg requests
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");

        RegistrationService.register(fName, lName, email, dob);

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);

        resp.getWriter().println("{\"status\":\"ok\"}");
    }
}