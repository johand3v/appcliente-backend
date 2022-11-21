package com.example.app.auth;


//@Configuration
//@EnableResourceServer
public class ResourceServerConfig { //extends ResourceServerConfigurerAdapter 

    /**
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers(HttpMethod.GET,"/api/clientes").permitAll()
                .anyRequest().authenticated();
    }
    **/


    // configuracion centralizada de la seguridad de las rutas
    /*
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/clientes").permitAll()
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource());
    }*/

    // PASO 1 crear en bean (metodo inyectable) de la configuracion del cors
    /*
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }*/

    // PASO 2 registra esta configuracion y la pasa a los interceptores del spring security
    /*
	@Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }*/


}
