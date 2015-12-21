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

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;
import controlador.BusinessDelegate;

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
			SemiElaboradoDTO se = new SemiElaboradoDTO();
			se.setCostoProduccion(Float.parseFloat(request.getParameter("costoProd")));
			se.setDescripcion(request.getParameter("desc"));
			UnidadDTO unAlm = new UnidadDTO();
			unAlm.setCodigo(Integer.parseInt(request.getParameter("unidad")));
			se.setUnidadAlmacenamiento(unAlm);
			List<MateriaPrimaDTO> listaMPs = new ArrayList<>();
			for (String s : st) {
				MateriaPrimaDTO mpDTO = new MateriaPrimaDTO();
				mpDTO.setCodigo(s);
				listaMPs.add(mpDTO);
			}
			se.setMeteriales(listaMPs);
			BusinessDelegate.getInstancia().grabarSE(se);

			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("Se ha creado satisfactoriamente el Semielaborado " + Integer.toString(se.getNumero()) + "<br>");
			pw.println("<a href=\"index.html\">Volver</a>");
			pw.println("</html>");
		}
	}
}