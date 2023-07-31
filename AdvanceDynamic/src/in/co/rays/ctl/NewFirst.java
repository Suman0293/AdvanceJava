package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/NewFirst")
public class NewFirst extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In New First");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		req.setAttribute("deal", "Big Deal...");
		
		RequestDispatcher rd = req.getRequestDispatcher("NewSecond");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In New First");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		resp.sendRedirect("NewSecond");
		
	}

}
