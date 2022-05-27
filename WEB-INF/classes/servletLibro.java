import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class servletLibro extends HttpServlet{
	
	private void respuestaServer(HttpServletResponse response, String imagen) throws IOException{
		PrintWriter enviarServer = response.getWriter();
		response.setContentType("text/html");
		enviarServer.println("<html>");
		enviarServer.println("<head><title>WEB Server Tomcat</title></head>");
    	enviarServer.println("<body>");
        enviarServer.println("<h1>Imagen Libro:</h1><p>");
        enviarServer.println("<hr>");
        enviarServer.println("<image align='center' alt='IMAGEN' src='../basics/images/COSMOS.jpg'>");
    	enviarServer.println("</body>");
		enviarServer.println("</html>");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//Obtener título del libro
		String imagen = request.getParameter("titulo");

		//Enviar imagen del libro correspondiente
		//respuestaServer(response, imagen);
		response.sendRedirect("RespuestaServer.jsp?titulo="+imagen);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
}