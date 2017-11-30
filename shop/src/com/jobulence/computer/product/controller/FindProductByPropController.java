package com.jobulence.computer.product.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobulence.computer.entity.Product;
import com.jobulence.computer.product.service.FindProductByPropService;

@Controller
@RequestMapping("product")
public class FindProductByPropController {

	@Resource
	private FindProductByPropService findProductByPropService;
	
	@RequestMapping("/findByName")
	public void findByName(@RequestParam("name") String name,HttpServletResponse rs,HttpSession session) {
		Product p = this.findProductByPropService.findProductByName(name);
		session.setAttribute("pro", p);
		try {
			rs.sendRedirect("../single-product.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
