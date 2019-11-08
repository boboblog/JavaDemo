package com.hwb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

//控制类 IndexController实现接口Controller ，提供方法handleRequest处理请求
//public class IndexController implements Controller 
@Controller
public class IndexController{

	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//SpringMVC通过 ModelAndView 对象把模型和视图结合在一起
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message","Hello Spring MVC");
		return mav;
	}
	
	@RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }  
	
    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer i = (Integer) session.getAttribute("count");
        if (i == null)
            i = 0;
        i++;
        session.setAttribute("count", i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }
    
    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session) {
    	session.setAttribute("count", 0);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }

}
