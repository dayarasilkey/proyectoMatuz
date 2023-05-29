package com.example.matizu.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @Column(nullable = false, length= 20)
    private String id_proveedor;
    @Column(nullable = false, length= 30)
    private String nombreProvedor;
    @Column(nullable = false, length= 15)
    private String telefono;
    @Column(nullable = false, length= 50, unique = true)
    private String email;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<DetalleProducto> detalleproductos;

    public Set<DetalleProducto> getDetalleproductos() {
        return detalleproductos;
    }

    public void setDetalleproductos(Set<DetalleProducto> detalleproductos) {
        this.detalleproductos = detalleproductos;
    }


//@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private Set<Productos> proveedor;
//
    //public Set<Productos> getProveedor() {
    //    return proveedor;
    //}
//
    //public void setProveedor(Set<Productos> proveedor) {
    //    this.proveedor = proveedor;
    //}

    public Proveedor() {
    }

    public Proveedor(String id_proveedor, String nombreProvedor, String telefono, String email) {
        this.id_proveedor = id_proveedor;
        this.nombreProvedor = nombreProvedor;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombreProvedor() {
        return nombreProvedor;
    }

    public void setNombreProvedor(String nombreProvedor) {
        this.nombreProvedor = nombreProvedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_proveedor='" + id_proveedor + '\'' +
                ", nombreProvedor='" + nombreProvedor + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
