package com.leichuangkj.druid.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 开启Druid监控功能配置类
 * @author steven
 * @date 2020-06-14
 */
@Configuration
public class DruidMonitorConfiguration {

    @Bean
    public ServletRegistrationBean druidStatView(){
        //使用ServletRegistrationBean进行注册
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单(共存时，deny优先于allow)，如果满足deny的话，会提示"Sorry, you are not permitted to view this page."
        servletRegistrationBean.addInitParameter("deny","192.168.124.7");
        //登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","admin123");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
