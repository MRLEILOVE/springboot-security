package com.leigq.www.springsecuritystudy.web;

import org.springframework.security.authentication.DisabledException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器验证图片验证码
 * <br/>
 * 使用过滤器的思路是：在Spring Security处理登录验证请求前，验证验证码，如果正确，放行；如果不正确，调到异常。
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 16:48 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class VerifyFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isProtectedUrl(request)) {
            String verifyCode = request.getParameter("verifyCode");
            if (!validateVerify(verifyCode)) {
                //手动设置异常
                request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", new DisabledException("验证码输入错误"));
                // 转发到错误Url
                request.getRequestDispatcher("/login/error").forward(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }

    private boolean validateVerify(String inputVerify) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 不分区大小写
        // 这个validateCode是在servlet中存入session的名字
        String validateCode = ((String) request.getSession().getAttribute("validateCode")).toLowerCase();
        inputVerify = inputVerify.toLowerCase();

        System.out.println("验证码：" + validateCode + "用户输入：" + inputVerify);
        return validateCode.equals(inputVerify);
    }

    // 拦截 /login的POST请求
    private boolean isProtectedUrl(HttpServletRequest request) {
        return "POST".equals(request.getMethod()) && pathMatcher.match("/login", request.getServletPath());
    }
}
