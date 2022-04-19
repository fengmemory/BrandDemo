package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author YF
 * @date 2022/4/15 - 17:28
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
  private  BrandService brandService= new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //1.接收数据 request.getParameter 不能接收json的数据
       /* String brandName = request.getParameter("brandName");
        System.out.println(brandName);*/
       //获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //将JSON字符串转化为JAVA对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);
        //2.调佣service方法完成添加
        brandService.add(brand);

        //3.响应成功标识
        response.getWriter().write("success");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
