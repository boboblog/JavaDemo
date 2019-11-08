package com.hwb.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONSerializer;

   
public class GetManyServlet extends HttpServlet { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setName("name"+i);
            hero.setHp(500+i);
            heros.add(hero);
        }
		//通过JSONSerializer.toJSON(heros)把集合转换为JSON字符串
		String result = JSONSerializer.toJSON(heros).toString();
		response.setContentType("text/html;charset=utf-8"); 
        response.getWriter().print(result);
    } 
	
	
}
