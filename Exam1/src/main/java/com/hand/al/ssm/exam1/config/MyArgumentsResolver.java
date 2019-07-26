package com.hand.al.ssm.exam1.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Configuration
public class MyArgumentsResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter( MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Page.class);
    }

    @Override
    public Object resolveArgument( MethodParameter parameter, ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Page parameterAnnotation = parameter.getParameterAnnotation(Page.class);
        Integer pageSize = Integer.parseInt(webRequest.getParameter("pageSize"));
        Integer page = Integer.parseInt(webRequest.getParameter("page"));
        String sort = webRequest.getParameter("sort");

        return new MyPage(pageSize,page,sort);
    }
}
