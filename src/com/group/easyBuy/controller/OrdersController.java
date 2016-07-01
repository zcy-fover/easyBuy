package com.group.easyBuy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.Orders;
import com.group.easyBuy.service.OrdersService;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet(description = "订单模块的控制器", urlPatterns = { "/OrdersController" })
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private OrdersService ordersService = new OrdersService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
    }

    public void addOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
	}
    
    public void viewOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	List<Orders> listOrders = new ArrayList<>();
    	
    	listOrders = ordersService.viewOrders();
    	for(Orders orders: listOrders){
    		System.out.println("订单输出：" + orders.getGoods() + "--" + orders.getTotalPrice());
    	}
    	
    	request.setAttribute("listOrders", listOrders);
    	request.getRequestDispatcher("/view/viewOrders.jsp").forward(request, response);
	}
    
    public void checkOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	
    	
	} 
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
