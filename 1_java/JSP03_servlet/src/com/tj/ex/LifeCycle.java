package com.tj.ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifeCycle() {
        super();
    }
    
    @PostConstruct
    public void postCon() {
    	System.out.println("1.지금 막 LifeCycle 서블릿 객체 생성함.");
    } // 만약 PostConstruct 가 있다면 init() 보다 먼저 실행됨.

    @Override
    public void init() throws ServletException {
    	System.out.println("2.init() 호출");
    } // 실행시 한번만 호출.
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("3.doGet() 호출");
    } //요청이 있을때 마다 실행.
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    } //요청이 있을때 마다 실행.
    
    @Override
    public void destroy() {
    	System.out.println("4. destroy() 호출");
    } // 톰켓이 죽을때 한번 실행됨.
    
    @PreDestroy
    public void PreDestroy() {
    	System.out.println("5. 지금 곧 LifeCycle 서블릿 객체가 사라짐");
    }
    
}
