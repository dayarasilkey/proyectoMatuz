package com.example.matizu.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;
    @Column(nullable = false, length= 50)
    private String nombre;
    @Column(nullable = false, length= 100)
    private String descripcion;
    @Column(nullable = false, length= 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;


    //@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private Set<Usuario> rol;
//
    //public Set<Usuario> getRol() {
    //    return rol;
    //}
//
    //public void setRol(Set<Usuario> rol) {
    //    this.rol = rol;
    //}


    public Rol() {
    }

    public Rol(Integer id_rol, String nombre, String descripcion, String estado) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id_rol='" + id_rol + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado +
                '}';
    }
}
