package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String inputId = req.getParameter("inputId");
		String inputPw1 = req.getParameter("inputPw1");
		String inputPw2 = req.getParameter("inputPw2");
		
		String inputName = req.getParameter("inputName");
		String inputEmail = req.getParameter("inputEmail");
		
		
		String[] color = req.getParameterValues("color");
		
		if(color != null) { // 체크된 메뉴가 있는지 검사
			
			// 향상된 for문
			for(String c :color) {
				System.out.println(c);
			}
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		out.println("<head>");
			out.println("<title>개인정보</title>");
		out.println("</head>");
		
		out.println("<body>");
		 out.println("<ul>");
		 	if(inputPw1.equals(inputPw2)) {
		 	out.println("<li>아이디 : "+ inputId+"</li>");
		 	out.println("<li>이름 : "+ inputName+"</li>");
		 	out.println("<li>이름 : "+ inputEmail+"</li>");
		 	out.println("<li>좋아하는색 : ");
		 		if(color != null) {
		 			for(String c:color) {
					 out.print(c +" ");
				 }
		 		}else {
				  out.print("없습니다");
		 		}
		 	out.println("</li>");
		    }else {
		    	out.print("비밀번호가일치하지않습니다");
		    }
		 
		 
		 out.println("</ul>");
		out.println("</body>");
		
		out.println("</html>");

	
		
		
		
		
		
		
		
		
		
	}
	
}
