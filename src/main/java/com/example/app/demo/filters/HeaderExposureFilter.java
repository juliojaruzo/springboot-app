package com.example.app.demo.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HeaderExposureFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ((HttpServletResponse) response).addHeader("access-control-expose-headers","location");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
