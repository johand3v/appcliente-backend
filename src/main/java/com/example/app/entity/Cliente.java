package com.example.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Nombre requerido 3 y 20 carcateres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Nombre requerido 3 y 20 carcateres" )
    @Column(name = "apellido")
    private String apellido;

    @NotEmpty
    @Email(message = "No esta bien formato")
    @Column(name = "aemail", nullable = false, unique = true)
    private String email;


    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;


    @Column(name = "foto")
    private String foto;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_region")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


}
