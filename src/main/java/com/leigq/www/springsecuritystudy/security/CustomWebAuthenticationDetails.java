package com.leigq.www.springsecuritystudy.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 该类提供了获取用户登录时携带的额外信息的功能，默认提供了 remoteAddress 与 sessionId 信息。
 * <br/>
 * 自定义的WebAuthenticationDetails，并在其中加入我们的验证码
 * <p>
 * 创建人：asus <br>
 * 创建时间：2018-12-06 17:09 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private static final long serialVersionUID = 6975601077710753878L;
    private final String verifyCode;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        // verifyCode为页面中验证码的name
        verifyCode = request.getParameter("verifyCode");
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    @Override
    public String toString() {
        String s = super.toString() + "; VerifyCode: " + this.getVerifyCode();
        System.out.println("CustomWebAuthenticationDetails.toString" + s);
        return s;
    }
}
