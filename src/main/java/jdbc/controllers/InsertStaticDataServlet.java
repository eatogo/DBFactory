package jdbc.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.model.DataDao;

@WebServlet("/InsertStaticData.do")
public class InsertStaticDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dbUsername = request.getParameter("dbUsername");
		String dbPassword = request.getParameter("dbPassword");
		
		DataDao dataDao = new DataDao(dbUsername, dbPassword);
		if (dataDao.isStaticDataExist() || dataDao.insertStaticData()) {
			request.setAttribute("StaticDataInserted", "ok");
			request.setAttribute("dbUsername", dbUsername);
			request.setAttribute("dbPassword", dbPassword);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
