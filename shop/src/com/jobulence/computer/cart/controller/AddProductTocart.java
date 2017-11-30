package com.jobulence.computer.cart.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobulence.computer.cart.service.AddCartService;
import com.jobulence.computer.entity.User;

@Controller
public class AddProductTocart {

	@Resource
	private AddCartService addCartService;
	
	@RequestMapping("addTocartT")
	public void addCart(@RequestParam("productname") String name,HttpSession session,HttpServletResponse rs) {
		
		User b = (User)session.getAttribute("user");
		this.addCartService.AddCartByName(name, b);
		System.out.println("添加成功");
		try {
			rs.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("addTocart")
	public void addToCart(@RequestParam("productname") String name,HttpSession session,HttpServletResponse rs) {
		User b = (User)session.getAttribute("user");
		this.addCartService.AddCartByName(name, b);
		System.out.println("添加成功");
		try {
			rs.sendRedirect("shop.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}