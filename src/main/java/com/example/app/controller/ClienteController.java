package com.example.app.controller;

import com.example.app.entity.Cliente;
import com.example.app.entity.Region;
import com.example.app.security001.AuthenticationReq;
import com.example.app.security001.JwtRequestFilter;
import com.example.app.security001.JwtUtilService;
import com.example.app.security001.TokenInfo;
import com.example.app.service.IClienteService;
import com.example.app.service.IUploadFileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController  {

	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    
	@Autowired
    private IClienteService servie;

    @Autowired
    private IUploadFileService uploadService;

    @GetMapping("/clientes/regiones")
    public List<Region> listarRegion(){
        return servie.listarRegion();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Cliente> index(@PathVariable Integer page){
        return servie.paginador(PageRequest.of(page, 5));
    }

    @GetMapping("/clientes")
    public List<Cliente> index(){
    	
        return servie.findAll();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Integer id) {

        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
             cliente = servie.findById(id);
        }catch (DataAccessException e) {
            response.put("mensjae", "Error al realizar la consulta");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }



        if (cliente == null) {
            response.put("mensjae", "El cliente ID:".concat(id.toString().concat(" no existe en la BD")));
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }


    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result)  {
        Cliente clienteNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "'" + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

      try {
         clienteNew = servie.save(cliente);
          response.put("mensjae", "Cliente ha sido registrado con EXITO ");
          response.put("cliente", clienteNew);
      }catch (DataAccessException e){
          response.put("mensjae", "Error al tratar de registrar un cliente");
          response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
          return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
      }

            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result) {

        Cliente clienteNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "'" + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = servie.save(cliente);

        } catch (DataAccessException e){
            response.put("mensjae", "Error al tratar de registrar un cliente");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensjae", "Cliente ha sido actualizado con EXITO ");
        response.put("cliente", clienteNew);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

        Map<String, Object> response = new HashMap<>();

        try {
            Cliente cliente = servie.findById(id);
            String nombreFotoAnterior = cliente.getFoto();

            uploadService.eliminar(nombreFotoAnterior);

            servie.delete(id);

        }catch (DataAccessException e){
            response.put("mensjae", "Error al tratar de eliminar un cliente");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensjae", "Se elimino con exito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Subir archivo
    @PostMapping("/clientes/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo")MultipartFile archivo, Integer id){

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = servie.findById(id);
        String nombreArchivo = null;
        if (!archivo.isEmpty()){
            try {
                nombreArchivo = uploadService.copiar(archivo);
            } catch (IOException e) {
                response.put("mensjae", "Error al subir la imagen " + nombreArchivo);
                response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
                return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = cliente.getFoto();
            uploadService.eliminar(nombreFotoAnterior);


            cliente.setFoto(nombreArchivo);
            servie.save(cliente);
            response.put("cliente", cliente);
            response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);

        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
        Resource recurso = null;
        try {
            recurso = uploadService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +recurso.getFilename()+"\"");

        return new ResponseEntity<>(recurso,cabecera, HttpStatus.OK);
    }
    
    
    /*SEGURIDAD 001
    

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    
    @GetMapping("/mensaje")
    public ResponseEntity<?> getMensaje() {
      var auth =  SecurityContextHolder.getContext().getAuthentication();
      logger.info("Datos del Usuario: {}", auth.getPrincipal());
      logger.info("Datos de los Permisos {}", auth.getAuthorities());
      logger.info("Esta autenticado {}", auth.isAuthenticated());

      Map<String, String> mensaje = new HashMap<>();
      mensaje.put("contenido", "Hola Peru");
      return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getMensajeAdmin() {

      var auth =  SecurityContextHolder.getContext().getAuthentication();
      logger.info("Datos del Usuario: {}", auth.getPrincipal());
      logger.info("Datos de los Permisos {}", auth.getAuthorities());
      logger.info("Esta autenticado {}", auth.isAuthenticated());

      Map<String, String> mensaje = new HashMap<>();
      mensaje.put("contenido", "Hola Admin");
      return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/publico")
    public ResponseEntity<?> getMensajePublico() {
      var auth =  SecurityContextHolder.getContext().getAuthentication();
      logger.info("Datos del Usuario: {}", auth.getPrincipal());
      logger.info("Datos de los Permisos {}", auth.getAuthorities());
      logger.info("Esta autenticado {}", auth.isAuthenticated());

      Map<String, String> mensaje = new HashMap<>();
      mensaje.put("contenido", "Hola Mundo");
      return ResponseEntity.ok(mensaje);
    }



    @PostMapping("/publico/authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
      System.out.println(authenticationReq);
    	logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());

      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
              authenticationReq.getClave()));

      final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
          authenticationReq.getUsuario());

      final String jwt = jwtUtilService.generateToken(userDetails);

      TokenInfo tokenInfo = new TokenInfo(jwt);

      return ResponseEntity.ok(tokenInfo);
    }

*/

}
