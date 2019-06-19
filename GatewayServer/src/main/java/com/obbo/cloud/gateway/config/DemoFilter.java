package com.obbo.cloud.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class DemoFilter extends ZuulFilter {

	private static Logger LOGGER = LoggerFactory.getLogger(DemoFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * filter logic here
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		LOGGER.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			LOGGER.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		LOGGER.info("ok");
		return null;
	}

}
