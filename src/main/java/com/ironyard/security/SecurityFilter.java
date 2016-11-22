package com.ironyard.security;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Raul on 11/11/16.
 */
public class SecurityFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        // check for key based authentication
        boolean authorized = false;
        String key = req.getHeader("x-authorization-key");
        if(key != null){
            authorized = SecurityUtils.isValidKey(key);
        }

        if(authorized){
            chain.doFilter(request, response);
        }else{
            // tell them NO!
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.getWriter().println("<html><body><p>No.. No..</p></body></html>");
        }


    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
