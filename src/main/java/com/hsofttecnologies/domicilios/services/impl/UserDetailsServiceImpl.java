package com.hsofttecnologies.domicilios.services.impl;

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
import org.springframework.transaction.annotation.Transactional;

import com.hsofttecnologies.domicilios.dao.UsuarioDao;
import com.hsofttecnologies.domicilios.entities.Rol;
import com.hsofttecnologies.domicilios.entities.Usuario;

@Service("userDetail")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioDao usuarioDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.buscarPorNombre(nombre);
		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getRoles());
		return buildUserForAuthentication(usuario, authorities);
	}

	private User buildUserForAuthentication(com.hsofttecnologies.domicilios.entities.Usuario user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUsuario(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Rol> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (Rol userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRol()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
