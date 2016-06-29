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
 * Servlet implementation class UserController
 */
@WebServlet(description = "管理用户的登录", urlPatterns = { "/UserController" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		UserService userService = new UserService();
		ServiceModel model = userService.login(user);

		Gson g = new Gson();
		String json = g.toJson(model);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();

	}

}
