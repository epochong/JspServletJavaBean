package com.epochong.controller;

import com.epochong.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author epochong
 * @date 2019/8/27 16:50
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        if (accountService.userLogin(userName,password)) {
            out.println("    <script>\n" +
                    "        alert(\"" + userName + "  " + password + "!\");\n" +
                    "    </script>");
        }else {
            // 登录失败,停留在登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确!\");\n" +
                    "    </script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
