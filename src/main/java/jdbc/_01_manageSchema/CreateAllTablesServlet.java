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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF8");
		
		DdlDao ddl = new DdlDao();
		if (ddl.createCompleteTables()) {
			req.setAttribute("sqlResult", "ok");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/_01_manageSchema/AllTablesCreateResult.jsp");
		rd.forward(req, resp);
//		resp.sendRedirect("/DBFactory/_01_manageSchema/AllTablesCreateResult.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
