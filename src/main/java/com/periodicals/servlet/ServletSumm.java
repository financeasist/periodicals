package com.periodicals.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSumm
 */
@WebServlet(urlPatterns="/servlet1", name ="ServletSumm")
public class ServletSumm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSumm() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int firstNumber = Integer.parseInt((String) request.getParameter("firstNumber"));
		int secondNumber = Integer.parseInt((String) request.getParameter("secondNumber"));
		int add = firstNumber + secondNumber;
		int subtract = firstNumber - secondNumber;
		int divide = firstNumber / secondNumber;
		int multiply = firstNumber * secondNumber;
		
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>This is response!</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		
		response.getWriter().println("The summ is : "+ add);
		response.getWriter().println("<br>The subtract is : "+ subtract);
		response.getWriter().println("The divide is : "+ divide);
		response.getWriter().println("The multiply is : "+ multiply);
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
