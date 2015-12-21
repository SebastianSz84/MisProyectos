package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Sistema;
import entities.MateriaPrima;
import entities.SemiElaborado;

/**
 * Servlet implementation class ListaMPporSE
 */
@WebServlet("/ListaMPporSE")
public class ListaMPporSE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaMPporSE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SemiElaborado se = Sistema.getInstancia().listarMPporSE(Integer.parseInt(request.getParameter("semiElab")));

		PrintWriter pw = response.getWriter();
		if (se == null) {
			pw.println("<html>Se han encontrado datos.<br><a href=\"index.html\">Volver</a></html>");
		} else {
			pw.println("<html><body><table border=\"1\"");
			pw.println("<tr>");
			pw.println("<td>Código</td>");
			pw.println("<td>Descripción</td>");
			pw.println("</tr>");
			for (MateriaPrima mp : se.getMeteriales()) {
				pw.println("<tr>");
				pw.println("<td>" + mp.getCodigo() + "</td>");
				pw.println("<td>" + mp.getDescripcion() + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table><a href=\"index.html\">Volver</a></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}