package com.sunshine.springcloud.zuul.module.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 过滤器的类型  此处为Pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 同类型的过滤器可能有多个  所以必须要指定执行顺序
        // 数字越小表示顺序越高，越先执行
        return 1 ; //FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        //表示是否需要执行该filter，true表示执行，false表示不执行
        return true;
    }

    @Override
    public Object run() {
        // 模拟对不携带token的请求进行限制
        RequestContext ctx = RequestContext.getCurrentContext();
        // RequestContext 记录了请求、响应、状态信息和数据，以便zuul的各个filters访问和共享。
        // RequestContext在请求期间生存，并且是线程本地的。（通过threadLocal获取）
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token") ;
        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        }else{
            // 不对请求进行路由（因为其他的filter的shouldFilter()方法的判断条件中都有ctx.setSendZuulResponse）例如RibbonRoutingFilter
            // 所以ctx.setSendZuulResponse一旦设置为false 则接下去的所有filter都不会被执行 也就不会被路由了
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("token must been exists");
            ctx.set("isSuccess", false);
        }
        return null;
    }
}
