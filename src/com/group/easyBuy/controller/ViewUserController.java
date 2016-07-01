package com.group.easyBuy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.User;
import com.group.easyBuy.service.UserService;

/**
 * Servlet implementation class ViewUserController
 */
@WebServlet(description = "展示所有用户", urlPatterns = { "/ViewUserController" })
public class ViewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserService userService = new UserService();
		
		List<User> listUser = new ArrayList<>();
		listUser = userService.viewUser();
		for(User user: listUser){
			System.out.println(user.getUsername());
		}
		
		request.setAttribute("listUser", listUser);
		
		request.getRequestDispatcher("/view/viewUser.jsp").forward(request, response);
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
