package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("MarksheetListView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String rollno = req.getParameter("rollno");
		String fName = req.getParameter("firstName");
		String lName = req.getParameter("lastName");
		String physics  = req.getParameter("physics");
		String chemistry = req.getParameter("chemistry");
		String maths = req.getParameter("maths");
		String total = req.getParameter("total");
		
	}

}
