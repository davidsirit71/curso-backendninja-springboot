package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	// este metodo se sobreescribe y viene de la interfaz de spring framwork
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.udemy.backendninja.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());

		return buildUser(user, authorities);
	}

	// metodo necesario para tranformar nuestro usuario a usuario spring
	private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {

		return new User(user.getUsername(), user.getPassword(), user.isEnable(), true, true, true, authorities); // accountNonExpired,
																													// credentialsNonExpired,
																													// accountNonLocked,
																													// se dejan a true

	}

	// transforma roles de usuario al objeto que maneja sringframework para saber
	// los roles de usuario
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

}