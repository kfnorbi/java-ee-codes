package hu.schonherz.administration.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.schonherz.administration.serviceapi.UserService;
import hu.schonherz.administration.serviceapi.dto.RoleDTO;
import hu.schonherz.administration.serviceapi.dto.UserDTO;


@Service("customUserDetailsService")
@EJB(name = "ejb.UserService", beanInterface = UserService.class)
public class CustomUserDetailsService implements UserDetailsService {

	@EJB
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UserDTO user;
		try {
			user = userService.findUserByName(username);
			
			for(RoleDTO e :  user.getRoles()){
				if(e.getName().equals("ROLE_ADMIN") && !user.isRemove() ){
					user.setRemove(true);
					List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
					return buildUserForAuthentication(user, authorities);
				}
			}
			throw new UsernameNotFoundException(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	private User buildUserForAuthentication(UserDTO user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleDTO> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (RoleDTO userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}