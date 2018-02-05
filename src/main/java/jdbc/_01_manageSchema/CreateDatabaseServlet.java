package jdbc._01_manageSchema;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateDatabaseJDBC.do")
public class CreateDatabaseServlet extends HttpServlet {
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
		
		SchemaDao ddl = new SchemaDao();
		if (ddl.createDatabase(dbUsername, dbPassword)) {
			request.setAttribute("DatabaseCreated", "ok");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
		rd.forward(request, response);
	}

}
