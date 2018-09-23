package com.sx.filter;

import org.junit.Test;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter()测试
 *
 *
 */

@WebFilter("/*")//过滤所有请求
public class MyFilter implements javax.servlet.Filter {

    public MyFilter() {
        System.out.println("MyFilter()构造方法被执行");
    }

    @Test
    public void destroy() {
        System.out.println("destory()方法被执行");
    }

    @Test
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("doFilter()方法被执行");
        chain.doFilter(req, resp);

    }

    @Test
    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

        System.out.println("init方法被执行");
    }

}
