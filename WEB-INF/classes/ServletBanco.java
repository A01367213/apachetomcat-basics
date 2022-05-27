import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ServletBanco extends HttpServlet{

	//Atributos
	private BancoADjdbc banco = new BancoADjdbc();
	//Metodos

	private String obtenerDatos(HttpServletRequest request){
		String nocta, nombre, tipo, saldo, datos;

		nocta = request.getParameter("nocta");
		nombre = request.getParameter("nombre");
		tipo = request.getParameter("tipo");
		saldo = request.getParameter("saldo");

		datos = nocta+"_"+nombre+"_"+tipo+"_"+saldo;

		return datos;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		String transaccion, datos, respuesta;

		// 1 Checar transacción
		
		transaccion = request.getParameter("boton");

		// 2 Transacción Capturar:
			// 2.1 Obtener datos del URL String
			// 2.2 Capturar datos en BD
			// 2.3 Enviar al server el resultado de la transaccion
		if (transaccion.equals("Capturar datos")){
			
			datos = obtenerDatos(request);

			respuesta = banco.capturar(datos);

			response.sendRedirect("RespuestaServer1.jsp?datos="+respuesta);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}