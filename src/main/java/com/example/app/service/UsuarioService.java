package com.example.app.service;


//@Service
public class UsuarioService { //implements UserDetailsService 

    //private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    //@Autowired
    //private IUsuarioDao usuarioDao;

    //@Override
    //@Transactional(readOnly = true)
    /*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) {
            logger.error("Error en login: no existe el usuario '"+username+"' en el sistema ");
            throw  new UsernameNotFoundException("Error en login: no existe el usuario '"+username+"' en el sistema ");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }*/
}
