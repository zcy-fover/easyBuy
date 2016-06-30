package com.group.easyBuy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group.easyBuy.dto.User;
import com.group.easyBuy.service.ServiceModel;
import com.group.easyBuy.service.UserService;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet(description = "控制添加用户", urlPatterns = { "/AddUserController" })
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phonenumber);
		user.setAddress(address);
		
		UserService userService = new UserService();
		ServiceModel model = userService.addUser(user); 
		System.out.println(model.getMessage() + "---" + model.getCode() + "---" + model.getData());
		
		request.getRequestDispatcher("/view/menu.html").forward(request, response);
		
		Gson g = new Gson();
		String json = g.toJson(model);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
