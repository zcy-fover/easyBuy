package com.group.easyBuy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.Admin;
import com.group.easyBuy.service.AdminService;
import com.group.easyBuy.service.ServiceModel;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(description = "管理员登陆控制器", urlPatterns = { "/AdminController" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		Admin a = new Admin();
		a.setUsername(username);
		a.setPassword(password);
		AdminService service = new AdminService();
		ServiceModel model = service.login(a);
		System.out.println(model.getMessage() + "---" + model.getCode() + "---" + model.getData());
		
		if(model.getCode() == 1){
			request.setAttribute("admin", username);
			request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
		} else{
			request.getSession().invalidate();
			request.setAttribute("message", model.getMessage());
			request.getRequestDispatcher("/").forward(request, response);
		}
		
		// 将业务模型对象转换为json字符串
//		Gson g = new Gson();
//		String json = g.toJson(model);
//		PrintWriter out = response.getWriter();
//		out.print(json);
//		out.flush();
	}

}
