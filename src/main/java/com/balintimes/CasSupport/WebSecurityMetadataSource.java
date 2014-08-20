package com.balintimes.CasSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class WebSecurityMetadataSource implements FilterInvocationSecurityMetadataSource
{

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException
	{
		HttpServletRequest request = ((FilterInvocation) object).getRequest();

		// // 获得请求的URL地址
		String requestUrl = ((FilterInvocation) object).getRequest().getServletPath();
		
		RequestMatcher requestMatcher = new AntPathRequestMatcher(requestUrl);

		if (requestMatcher.matches(request))
		{ 
			//UserResourceAuthority authority = this.resourcesService.GetUserResourceAndAuthorityByURL(requestUrl);
			List<ConfigAttribute> attributesSet = new ArrayList<ConfigAttribute>(1);
			ConfigAttribute attribute = new SecurityConfig(requestUrl);
			
			attributesSet.add(attribute);
			
			return attributesSet;
		}
		
		return null;
		 
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz)
	{
		// TODO Auto-generated method stub
		return true;
	}

}
