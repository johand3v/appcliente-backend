package com.example.app.security001;


//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {//extends WebSecurityConfigurerAdapter
	 
/*
	  @Autowired
	  UserDetailsService usuarioDetailsService;

	  @Autowired
	  private JwtRequestFilter jwtRequestFilter;

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        //.httpBasic(withDefaults())  // (1)
        .csrf().disable() // (2)
        .authorizeRequests()
        .antMatchers("/publico/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and().cors()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	    auth.userDetailsService(usuarioDetailsService);

//		auth
//			.inMemoryAuthentication()
//			.withUser("usario").password("{noop}" + "secreto").roles("USER")
//			.and()
//			.withUser("admin").password("{noop}" + "secreto").roles("ADMIN");

	}
	
	
*/

}

	
	
	

