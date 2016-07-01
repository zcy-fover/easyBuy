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
 * Servlet implementation class GetCategoryController
 */
@WebServlet(description = "获取商品分类", urlPatterns = { "/GetCategoryController" })
public class GetCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCategoryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Category> listCategory = new ArrayList<>();
		CategoryService categoryService = new CategoryService();
		listCategory = categoryService.getCategory();
		
		for(Category category: listCategory){
			System.out.println(category.getCname() + "---" + category.getSummary());
		}
		
		request.setAttribute("listCategory", listCategory);
		
		request.getRequestDispatcher("/view/viewCategory.jsp").forward(request, response);;
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
