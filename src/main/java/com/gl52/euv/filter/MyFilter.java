package com.gl52.euv.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


//@WebFilter(filterName = "myFilter",urlPatterns ={"*.do"} )
@WebFilter(filterName = "myFilter",urlPatterns ="/uv" )
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入First Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开First Filter");

    }

    public void destroy() {

    }
}
