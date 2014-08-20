package com.balintimes.CasSupport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WebCasAuthenticationUserDetailsService implements AuthenticationUserDetailsService<Authentication>
{

	@Override
	public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException
	{
		CasAssertionAuthenticationToken casToken = (CasAssertionAuthenticationToken) token;
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(1);

		return new User(casToken.getName(), "", grantedAuthorities);
	}

}
