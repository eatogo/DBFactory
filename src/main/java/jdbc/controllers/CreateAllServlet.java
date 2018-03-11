package jdbc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.model.DataDao;
import jdbc.model.SchemaDao;

@WebServlet("/CreateAll.do")
public class CreateAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF8");
		String dbUsername = request.getParameter("dbUsername");
		String dbPassword = request.getParameter("dbPassword");

		SchemaDao schemaDao = new SchemaDao(dbUsername, dbPassword);
		DataDao dataDao = new DataDao(dbUsername, dbPassword);
		if (schemaDao.createAllSchema() && dataDao.insertAllData()) {
			request.setAttribute("AllSchemaCreated", "ok");
			request.setAttribute("dbUsername", dbUsername);
			request.setAttribute("dbPassword", dbPassword);
			RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}