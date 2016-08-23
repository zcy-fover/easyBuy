package com.group.easyBuy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.Category;
import com.group.easyBuy.service.CategoryService;

/**
 * Servlet implementation class ViewCategoryController
 */
@WebServlet(description = "显示所有种类", urlPatterns = { "/ViewCategoryController" })
public class ViewCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCategoryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	List<Category> listCategory = new ArrayList<>();
    	listCategory = categoryService.getCategory();
    	
    	for(Category category: listCategory){
    		System.out.println("商品种类：" + category.getCname());
    	}
    	
    	request.setAttribute("listCategory", listCategory);
    	request.getRequestDispatcher("/view/viewCategory.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
