package com.example.app.auth;



//@Configuration
public class SpringSecurityConfig { // extends WebSecurityConfigurerAdapter

	/*
    @Autowired
    private UserDetailsService usuarioService; */


	/*
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } */


	/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
    } */

	/*
    @Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    } */


	/*
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //estoy permitiendo ataques cors


    }*/

}
