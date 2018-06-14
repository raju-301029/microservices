package com.payroll.microservices.zuuledgeserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest req = requestContext.getRequest();

		log.info(String.format("%s request to %s", req.getMethod(), req.getRequestURL().toString()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
