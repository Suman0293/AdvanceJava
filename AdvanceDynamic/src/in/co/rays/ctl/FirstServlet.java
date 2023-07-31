package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In Do Get");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String[] address = req.getParameterValues("address");

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(loginId);
		System.out.println(password);
		System.out.println(address[0]);
		System.out.println(address[1]);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello Second Servlet....!!!!!</h>");
		out.print(firstName + " " + lastName + " " + loginId + " " + password + " " + address[0] + " " + address[1]);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
