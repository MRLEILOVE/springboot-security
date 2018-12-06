package com.leigq.www.springsecuritystudy;

import com.leigq.www.springsecuritystudy.web.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/*
* 解决MySQL报错The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents ....
* https://www.jitwxs.cn/67c1d1e1.html
* */
@SpringBootApplication
public class SpringsecuritystudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritystudyApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean<VerifyServlet> indexServletRegistration() {
        ServletRegistrationBean<VerifyServlet> registration = new ServletRegistrationBean<>(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }


}
