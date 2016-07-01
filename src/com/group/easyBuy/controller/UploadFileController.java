package com.group.easyBuy.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softeem.jspsmart.upload.SmartUpload;
import com.softeem.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadFileController
 */
@WebServlet(description = "控制文件上传", urlPatterns = { "/UploadFileController" })
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			//初始化SmartUpload对象
			SmartUpload su = new SmartUpload();
			su.initialize(this, request, response);
			//设置允许上传文件类型
			su.setAllowedFilesList("png,jpg,bmp,jpeg");
			//设置允许上传的单个文件大小
			su.setMaxFileSize(1024*1024*10);//10M
			//设置允许上传的文件总大小
			su.setTotalMaxFileSize(1024*1024*10*10);//100M
			//上传
			su.upload();
			
			String root = this.getServletContext().getRealPath("/myflie");
			File f = new File(root);
			if(!f.exists()){
				//如果目录不存在则创建
				f.mkdirs();
			}
			System.out.println(root);
			su.save(root);
		} catch (SmartUploadException e) {
			e.printStackTrace();
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
