package com.balintimes.CasSupport;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class WebAccessDecisionManager implements AccessDecisionManager
{

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException
	{
		// TODO Auto-generated method stub

		if (configAttributes == null)
		{
			return;
		}

		User user = (User) authentication.getPrincipal();
		System.out.println("this object value is: " + user.toString());
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();

		while (iterator.hasNext())
		{
			SecurityConfig config = (SecurityConfig) iterator.next();

			if (config.getAttribute().equals(""))
			{
				return;
			}
			else if (config.getAttribute().equals("/admin/superAdmin.jsp"))
			{
				throw new AccessDeniedException(" 没有权限访问！ ");
			}
		}
	}

	@Override
	public boolean supports(ConfigAttribute attribute)
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz)
	{
		// TODO Auto-generated method stub
		return true;
	}

}
