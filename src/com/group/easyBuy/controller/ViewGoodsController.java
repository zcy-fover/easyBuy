package com.group.easyBuy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.Goods;
import com.group.easyBuy.service.GoodsService;

/**
 * Servlet implementation class ViewGoodsController
 */
@WebServlet(description = "展示所有商品", urlPatterns = { "/ViewGoodsController" })
public class ViewGoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGoodsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		GoodsService goodsService = new GoodsService();
		
		List<Goods> listGoods = new ArrayList<>();
		listGoods = goodsService.viewGoods();
		
		for(Goods goods: listGoods){
			System.out.println("商品列表输出：" + goods.getGname() + "--" + goods.getCategory().getCname());
		}
		
		request.setAttribute("listGoods", listGoods);
		request.getRequestDispatcher("/view/viewGoods.jsp").forward(request, response);
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
