package com.group.easyBuy.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dao.impl.CategoryDAO;
import com.group.easyBuy.dto.Category;
import com.group.easyBuy.dto.Goods;
import com.group.easyBuy.service.GoodsService;
import com.group.easyBuy.service.ServiceModel;

/**
 * Servlet implementation class AddGoodsController
 */
@WebServlet(description = "添加商品", urlPatterns = { "/AddGoodsController" })
public class AddGoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		GoodsService goodsService = new GoodsService();
		
		String gname = request.getParameter("gname");
		Double price = Double.parseDouble(request.getParameter("price"));
		Double offset = Double.parseDouble(request.getParameter("offset"));
		Integer storage = Integer.parseInt(request.getParameter("storage"));
		Timestamp time = Timestamp.valueOf(request.getParameter("time"));
		
		String cname = request.getParameter("cname");
//		String summary = request.getParameter("summary");
		
		Goods  goods = new Goods();
		Category category = new Category();
		CategoryDAO categoryDAO = new CategoryDAO();
		
		category.setCname(cname);
		category =categoryDAO.findSingle(category);
		
		goods.setGname(gname);
		goods.setCategory(category);
		goods.setPrice(price);
		goods.setOffset(offset);
		goods.setStorage(storage);
		goods.setTime(time);
		System.out.println(goods.getGname() + "--" + goods.getOffset() + "--" + goods.getCategory().getCid());
		ServiceModel model = goodsService.addGoods(goods);
		
		System.out.println(model.getMessage() + "---" + model.getCode() + "---" + model.getData());
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
