package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HibernateDAO;
import entities.MateriaPrima;
import entities.SemiElaborado;

/**
 * Servlet implementation class AltaSE
 */
@WebServlet("/AltaSE")
public class AltaSE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaSE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] st = request.getParameterValues("mp");
		if (st.length != 0) {
			SemiElaborado se = new SemiElaborado();
			se.setCostoProduccion(Float.parseFloat(request.getParameter("costoProd")));
			se.setDescripcion(request.getParameter("desc"));
			se.setUnidadAlmacenamiento(HibernateDAO.getInstancia().leerUN(Integer.parseInt(request.getParameter("unidad"))));
			List<MateriaPrima> listaMPs = new ArrayList<>();
			for (String s : st) {
				listaMPs.add(HibernateDAO.getInstancia().leerMP(s));
			}
			se.setMeteriales(listaMPs);
			HibernateDAO.getInstancia().grabarSE(se);
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("Se ha creado satisfactoriamente el Semielaborado " + Integer.toString(se.getNumero()) + "<br>");
			pw.println("<a href=\"index.html\">Volver</a>");
			pw.println("</html>");
		}
	}
}