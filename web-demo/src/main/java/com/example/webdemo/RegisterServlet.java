package com.example.webdemo;

import com.example.webdemo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "registerServlet", value = "/registration")
public class RegisterServlet extends HttpServlet {
    User user = null;
    private final String userId = "Amit";
    private final String pwd = "pass123";
    public void init(){
        user = new User();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String userName = request.getParameter("username");
       String password = request.getParameter("pwd");

       List<User> userList = Arrays.asList(new User("Dave","123"),
               new User("Tom","456"),new User("Pete","099"));
       if(userId.equals(userName) && pwd.equals(password)){
           Cookie loginCookie = new Cookie("user",userName);
           loginCookie.setMaxAge(15*60);
           response.addCookie(loginCookie);
           request.setAttribute("userList", userList);
           String baseUrl = request.getContextPath();
          // response.sendRedirect(baseUrl+"/pages/register.jsp");
           RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
           rd.forward(request,response);
       }
       else{
           RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
           PrintWriter out = response.getWriter();
           out.println("<font color=red>Username or password is incorrect</font>");
           rd.include(request,response);
       }

      // user.setUserName(userName);
        //System.out.println("Username: "+userName);
        //System.out.println("Password: "+password);
       /* String greet = "Hello "+userName+"!";
        request.setAttribute("key", greet);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/register.jsp");
        rd.forward(request,response);*/
    }

    //MVC Architecture
    //Session tracking

}
