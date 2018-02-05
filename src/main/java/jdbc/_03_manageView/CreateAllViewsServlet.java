package jdbc._03_manageView;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAllViews.do")
public class CreateAllViewsServlet extends HttpServlet {
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
		ViewDao dao = new ViewDao();
		if (dao.createFoodWithLocationView(dbUsername, dbPassword)) {
			request.setAttribute("ViewsCreated", "ok");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/ResultPage.jsp");
		rd.forward(request, response);
	}

}
