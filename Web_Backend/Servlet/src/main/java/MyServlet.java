import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");//GET요청을 받음
		System.out.println(req.getParameter("action"));
		System.out.println(req.getParameter("action2"));
		
		
		resp.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>Hello! Servlet!</h1>
		  </body>
		</html>
		""");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST");
		System.out.println(req.getParameter("action"));
		System.out.println(req.getParameter("dan"));
		resp.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>뭐라는거야?</h1>
		  </body>
		</html>
		""");
		
	}

}
