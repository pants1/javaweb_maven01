package com.smbms.interceptor;

import com.smbms.entity.User;
import com.smbms.until.LoginSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class LoginInterceptor  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {
        String uri = request.getRequestURI();
        if (uri.contains("login")){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(LoginSession.SESSION_USER);
        if(user==null){
            request.setAttribute("error", "您还没有登录，请先登录！");
            String contextPath = request.getContextPath();
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        }
        return  true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
