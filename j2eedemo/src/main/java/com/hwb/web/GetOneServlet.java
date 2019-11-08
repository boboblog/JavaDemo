package com.hwb.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

   
public class GetOneServlet extends HttpServlet { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		Hero hero = new Hero();
		hero.setName("盖伦");
		hero.setHp(353);
		
		JSONObject json = new JSONObject();
		//把Hero对象转换为JSONObject 对象
		json.put("hero", JSONObject.fromObject(hero));
		response.setContentType("text/html;charset=utf-8"); 
	    response.getWriter().print(json);
	    
    } 
}
