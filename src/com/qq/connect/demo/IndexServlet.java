package com.qq.connect.demo;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("qqLogin=======================================================");
        response.setContentType("text/html;charset=utf-8");  // 响应编码
        // 跳转QQ登录页面
        try {
            /*String url = new Oauth().getAuthorizeURL(request);
            System.out.println(url);
            response.sendRedirect(url);*/
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,  response);
    }
}