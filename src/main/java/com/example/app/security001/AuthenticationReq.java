package com.example.app.security001;

import java.io.Serializable;

public class AuthenticationReq implements Serializable {

  private static final long serialVersionUID = 1L;

  private String usuario;

  private String clave;

  public AuthenticationReq(String usuario, String clave) {
    this.usuario = usuario;
    this.clave = clave;
  }

  public String getUsuario() {
    return this.usuario;
  }

  public void setUsuario(String username) {
    this.usuario = username;
  }

  public String getClave() {
    return this.clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }
}

