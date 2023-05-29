package com.example.matizu.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @Column(nullable = false, length= 30)
    private String id_producto;
    @Column(nullable = false, length= 30)
    private String codProducto;
    @Column(nullable = false, length= 30)
    private String nombreProd;
    @Column(name = "precioCantidad", length = (100))
    private Float precioProducto;
    @Column(name = "stock", length = (100))
    private int stock;
    @Column(nullable = false, length= 50)
    private String descripcion;

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<DetallePedido> detallepedido;

    public Set<DetallePedido> getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(Set<DetallePedido> detallepedido) {
        this.detallepedido = detallepedido;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<DetalleProducto> detalleproductos;

    public Set<DetalleProducto> getDetalleproductos() {
        return detalleproductos;
    }

    public void setDetalleproductos(Set<DetalleProducto> detalleproductos) {
        this.detalleproductos = detalleproductos;
    }

    //@ManyToOne(fetch = FetchType.LAZY, optional= false)
    //@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    //@JsonIgnore
    //private Categoria categoria;
//
    //@OneToMany(mappedBy = "productos", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private Set<DetallePedido> productos;
//
    //public Set<DetallePedido> getProductos() {
    //    return productos;
    //}
//
    //public void setProductos(Set<DetallePedido> productos) {
    //    this.productos = productos;
    //}
//
    //@OneToMany(mappedBy = "productos", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private Set<DetalleProducto> productosp;
//
    //public Set<DetalleProducto> getProductosp() {
    //    return productosp;
    //}
//
    //public void setProductosp(Set<DetalleProducto> productosp) {
    //    this.productosp = productosp;
    //}

    public Productos() {
    }

    public Productos(String id_producto, String codProducto, String nombreProd, Float precioProducto, int stock, String descripcion) {
        this.id_producto = id_producto;
        this.codProducto = codProducto;
        this.nombreProd = nombreProd;
        this.precioProducto = precioProducto;
        this.stock = stock;
        this.descripcion = descripcion;
        //this.categoria = categoria;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //public Categoria getCategoria() {
    //    return categoria;
    //}
//
    //public void setCategoria(Categoria categoria) {
    //    this.categoria = categoria;
    //}

    @Override
    public String toString() {
        return "Productos{" +
                "id_producto='" + id_producto + '\'' +
                ", codProducto='" + codProducto + '\'' +
                ", nombreProd='" + nombreProd + '\'' +
                ", precioProducto=" + precioProducto +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                //", categoria=" + categoria +
                '}';
    }
}
