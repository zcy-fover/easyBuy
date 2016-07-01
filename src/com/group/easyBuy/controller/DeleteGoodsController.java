package com.group.easyBuy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.easyBuy.dto.Goods;
import com.group.easyBuy.service.GoodsService;

/**
 * Servlet implementation class DeleteGoodsController
 */
@WebServlet(description = "删除商品", urlPatterns = { "/DeleteGoodsController" })
public class DeleteGoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoodsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String gname = request.getParameter("gname");
		Goods goods = new Goods();
		goods.setGname(gname);
		GoodsService goodsService = new GoodsService();
		boolean isAccess = goodsService.deleteGoods(goods);
		if(isAccess){
			System.out.println("删除成功-商品名字----" + gname);
		}
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
