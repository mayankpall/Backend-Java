package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        // --- Name validation: starts with Cap, at least 3 chars ---
        if (name == null || !name.matches("[A-Z][a-zA-Z]{2,}")) {
            out.println("<h3 style='color:red;'>Invalid Name! Name must start with a capital letter and have at least 3 characters.</h3>");
            out.println("</body></html>");
            return;
        }

        // --- Password Validation ---
        if (password == null || password.length() < 8) {
            out.println("<h3 style='color:red;'>Password must be at least 8 characters.</h3>");
            out.println("</body></html>");
            return;
        }
        if (!password.matches(".*[A-Z].*")) {
            out.println("<h3 style='color:red;'>Password must contain at least one uppercase letter.</h3>");
            out.println("</body></html>");
            return;
        }
        if (!password.matches(".*\\d.*")) {
            out.println("<h3 style='color:red;'>Password must contain at least one digit.</h3>");
            out.println("</body></html>");
            return;
        }
        // Exactly one special character
        String specialChars = password.replaceAll("[a-zA-Z0-9]", "");
        if (specialChars.length() != 1) {
            out.println("<h3 style='color:red;'>Password must have exactly one special character.</h3>");
            out.println("</body></html>");
            return;
        }

        // --- Now regular login validation ---
        if ("admin".equals(username) && "Admin@123".equals(password)) {
            out.println("<h2>Login successful!</h2>");
        } else {
            out.println("<h2>Invalid username or password.</h2>");
        }
        out.println("</body></html>");
    }

}
