package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * Created by BF on 2017/9/29.
 */
public class Interceptor implements HandlerInterceptor
{
    public String defultLogin="/login.jsp";//默认登录页面
    private List<String> excludeUrls;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception
    {
        System.out.println("进入preHandle方法");
        //获取请求url
        String requestUrl = request.getRequestURI();
        //如果请求url与忽略拦截url相同，则直接返回ture
        for (String url:excludeUrls)
        {
            if (requestUrl.endsWith(url)){
                System.out.println(url);
                return true;
            }
        }
        if(request.getSession().getAttribute("user")!=null)
        {
            return true;
        }
        else
        {
            System.out.println(requestUrl);
            System.out.println("没有登录，跳回登录页面");
            response.sendRedirect(defultLogin);
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {
        System.out.println("进入postHandle方法");
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {
        System.out.println("进入afterCompletion方法");
    }

    //生成不被拦截的urlset方法，get方法可忽略
    public void setExcludeUrls(List excludeUrls)
    {
        this.excludeUrls = excludeUrls;
    }
}
