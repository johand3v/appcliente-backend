package com.example.app.security001;


import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService   {//implements UserDetailsService

	/**
	  @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Map<String, String> usuarios = Map.of(
	        "usuario", "USER",
	        "admin", "ADMIN"
	    );
	    var rol = usuarios.get(username);
	    if (rol != null) {
	      User.UserBuilder userBuilder = User.withUsername(username);
	      // "secreto" => [BCrypt] => $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
	      String encryptedPassword = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
	      userBuilder.password(encryptedPassword).roles(rol);
	      return userBuilder.build();
	    } else {
	      throw new UsernameNotFoundException(username);
	    }

	  }
	  
	  */
	}
