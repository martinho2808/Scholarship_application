package Scholarship_application.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Scholarship_application.beans.loginBean;

public class loginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public loginServlet() {
			super();
			// TODO Auto-generated constructor stub
		}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginBean loginBean = null;
        String jdbcDriver = getInitParameter("jdbcDriver");
        String dbURL = getInitParameter("dbURL");
        String dbUserName = getInitParameter("dbUserName");
        String dbPassword = getInitParameter("dbPassword");
        
        try {
            // Get database configuration from servlet context


            // Create an instance of LoginBean with the database configuration
            loginBean = new loginBean(jdbcDriver, dbURL, dbUserName, dbPassword);
            loginBean.setUsername(request.getParameter("username"));
            loginBean.setPassword(request.getParameter("password"));

            // Assume checkLogin() is a method that returns true if the user exists and the password matches
            if (loginBean.checkLogin(jdbcDriver, dbURL, dbUserName, dbPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", loginBean.getUsername());
                System.out.println("Login successful");
                response.sendRedirect("index.jsp"); // Redirect to home page on successful login
            } else {
            	request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("loginpage.jsp").forward(request, response); // Forward back to login page with error message
            }
        } catch (Exception e) {
            e.printStackTrace();

            String errorMessage = "An error occurred: " + e;
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("jdbcDriver", jdbcDriver);
            request.setAttribute("dbURL", dbURL);
            request.setAttribute("dbUserName", dbUserName);
            request.setAttribute("dbPassword", dbPassword);
            if (loginBean != null) {
                request.setAttribute("username", loginBean.getUsername());
                request.setAttribute("password", loginBean.getPassword());
            }
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
        }
    }
}