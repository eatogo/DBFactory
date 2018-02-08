package jdbc._04_createAll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc._02_manageData.DataDao;
import jdbc._03_manageView.ViewDao;

@WebServlet("/CreateAllSchema.do")
public class CreateAllSchemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String dbUsername = request.getParameter("dbUsername");
		String dbPassword = request.getParameter("dbPassword");

		SchemaDao ddl = new SchemaDao();
		ViewDao vdao = new ViewDao();
		DataDao dao = new DataDao();
		if (ddl.createAllSchema(dbUsername, dbPassword)) {
			if (vdao.createFoodWithLocationView(dbUsername, dbPassword)) {
				if (dao.insertAllData(dbUsername, dbPassword)) {
					request.setAttribute("AllSchemaCreated", "ok");
					request.setAttribute("dbUsername", dbUsername);
					request.setAttribute("dbPassword", dbPassword);
				}
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
		rd.forward(request, response);
	}

}
