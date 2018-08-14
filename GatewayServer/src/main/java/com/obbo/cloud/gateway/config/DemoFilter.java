package com.obbo.cloud.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class DemoFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DemoFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO filter's logic
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
		LOGGER.info(s);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
