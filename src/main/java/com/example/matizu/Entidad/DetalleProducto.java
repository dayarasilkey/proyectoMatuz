package com.example.matizu.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleproducto")
public class DetalleProducto {
    @Id
    @Column(nullable = false, length= 30)
    private String id_detallepro;
    @Column(nullable = false, length= 50)
    private String descripcionDetallePro;


    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @JsonIgnore
    private Productos productos;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @JsonIgnore
    private Proveedor proveedor;

    public DetalleProducto() {
    }

    public DetalleProducto(String id_detallepro, String descripcionDetallePro) {
        this.id_detallepro = id_detallepro;
        this.descripcionDetallePro = descripcionDetallePro;
        // this.productos = productos;
        //  this.proveedor = proveedor;
    }

    public String getId_detallepro() {
        return id_detallepro;
    }

    public void setId_detallepro(String id_detallepro) {
        this.id_detallepro = id_detallepro;
    }

    public String getdescripcionDetallePro() {
        return descripcionDetallePro;
    }

    public void setDescripcionDetallePro(String descripcionDetallePro) {
        this.descripcionDetallePro = descripcionDetallePro;
    }

    // public Productos getProductos() {
    //     return productos;
    // }

    // public void setProductos(Productos productos) {
    //     this.productos = productos;
    // }

    // public Proveedor getProveedor() {
    //     return proveedor;
    // }

    // public void setProveedor(Proveedor proveedor) {
    //     this.proveedor = proveedor;
    // }

    @Override
    public String toString() {
        return "DetalleProducto{" +
                "id_detallepro='" + id_detallepro + '\'' +
                ", descripcionDetallePro='" + descripcionDetallePro + '\'' +
                //      ", productos=" + productos +
                //      ", proveedor=" + proveedor +
                '}';
    }
}
