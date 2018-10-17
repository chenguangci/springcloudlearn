package com.beiyi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 决定过滤器在哪个生命周期执行，“pre”为路由之前
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 优先级，越小越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否需要过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体逻辑
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("access token is null");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token is ok");
        return null;
    }
}
