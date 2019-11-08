package com.hwb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hwb.pojo.Product;

@Controller
public class ProductController {
	
	@RequestMapping("/addProduct")
	public ModelAndView add(Product product) throws Exception{
		ModelAndView mav = new ModelAndView("showProduct");
		return mav;
	}
}
