package com.hwb.web;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Servlet的生命周期开始于：用户访问浏览器对应的路径开始，调用到了该Servlet
    public LoginServlet() {    
        super();
        System.out.println("LogServlet的构造方法在其生命周期内仅执行一次");
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
        System.out.println("LogServlet的初始化方法，在其生命周期也仅执行一次");
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("用继承自HttpServlet的service代替doget和dopost");
    	
    	request.setCharacterEncoding("UTF-8"); 
        String name = request.getParameter("name");   
        //System.out.println(name);
        String password = request.getParameter("password");
 
//        String html = null;
 
        if ("admin".equals(name) && "123".equals(password))
           request.getRequestDispatcher("success.html").forward(request, response);
        else
            response.sendRedirect("fail.html");
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter pw = response.getWriter();
//        pw.println(html); 
 
    }
    public void destroy() {
        System.out.println("destroy()");
        System.out.println("LogServlet的销毁");
    }
 

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String html = null;
//        
//        if ("admin".equals(name) && "123".equals(password))
//            html = "<div style='color:green'>success</div>";
//        else
//            html = "<div style='color:red'>fail</div>";
//  
//        PrintWriter pw = response.getWriter();
//        pw.println(html);
//	}

}
