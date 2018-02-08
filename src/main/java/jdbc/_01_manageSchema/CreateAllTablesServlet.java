package jdbc._01_manageSchema;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAllTablesJDBC.do")
public class CreateAllTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String dbUsername = request.getParameter("dbUsername");
		String dbPassword = request.getParameter("dbPassword");

		SchemaDao ddl = new SchemaDao();
		if (ddl.createAllTables(dbUsername, dbPassword)) {
			request.setAttribute("TablesCreated", "ok");
			request.setAttribute("dbUsername", dbUsername);
			request.setAttribute("dbPassword", dbPassword);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
