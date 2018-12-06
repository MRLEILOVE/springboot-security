package com.leigq.www.springsecuritystudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:58 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Controller
@Slf4j
public class LoginController {
    @RequestMapping("/")
    public String showHome() {
        /*
        * SecurityContextHolder:
        *
        * SecurityContextHolder用于存储安全上下文（security context）的信息。
        * 当前操作的用户是谁，该用户是否已经被认证，他拥有哪些角色权限…这些都被
        * 保存在SecurityContextHolder中。SecurityContextHolder默认使用
        * ThreadLocal 策略来存储认证信息。看到ThreadLocal 也就意味着，
        * 这是一种与线程绑定的策略。Spring Security在用户登录时自动绑定
        * 认证信息到当前线程，在用户退出时，自动清除当前线程的认证信息。
        *
        * Authentication:
        * 1,Authentication是spring security包中的接口，直接继承自Principal类，
        * 而Principal是位于java.security包中的。可以见得，Authentication在spring security
        * 中是最高级别的身份/认证的抽象。
        * 2,由这个顶级接口，我们可以得到用户拥有的权限信息列表，密码，用户细节信息，用户身份信息，认证信息。
        *
        * Authentication中的方法:
        * 1,getAuthorities()，权限信息列表，默认是GrantedAuthority接口的一些实现类，
        * 通常是代表权限信息的一系列字符串。
        * 2,getCredentials()，密码信息，用户输入的密码字符串，在认证过后通常会被移除，用于保障安全。
        * 3,getDetails()，细节信息，web应用中的实现接口通常为 WebAuthenticationDetails，
        * 它记录了访问者的ip地址和sessionId的值。
        * 4,getPrincipal()，敲黑板！！！最重要的身份信息，大部分情况下返回的是UserDetails接口的实现类，
        * 也是框架中的常用接口之一。UserDetails接口将会在下面的小节重点介绍。
        * */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //获取当前登录用户
        String name = authentication.getName();
        log.info("当前登陆用户：{}", name);

        return "home";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓判断是否有角色↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/
//    @RequestMapping("/admin")
//    @ResponseBody
//    /*
//    * @PreAuthorize 用于判断用户是否有指定权限，没有就不能访问,
//    * 这里是判断用户是否有 'ROLE_ADMIN' 权限
//    * */
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String printAdmin() {
//        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
//    }
    /*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑判断是否有角色↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/


    /*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓判断是否有权限↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/
    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','r')")
    public String printAdminR() {
        return "如果你看见这句话，说明你访问/admin路径具有r权限";
    }

    @RequestMapping("/admin/c")
    @ResponseBody
    @PreAuthorize("hasPermission('/admin','c')")
    public String printAdminC() {
        return "如果你看见这句话，说明你访问/admin路径具有c权限";
    }

    /*↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑判断是否有权限↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑*/

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }
}
