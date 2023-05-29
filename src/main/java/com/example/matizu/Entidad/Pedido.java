package com.example.matizu.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(length = 30)
    private String id_pedido;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "impuesto", length = (100))
    private int impuesto;

    @Column(name = "totalped", length = (100))
    private int totalped;
    @Column(nullable = false, length= 50)
    private String estadop;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<DetallePedido> detallepedido;

    public Set<DetallePedido> getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(Set<DetallePedido> detallepedido) {
        this.detallepedido = detallepedido;
    }


    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Entrega entrega;


    @PrePersist
    public void fechaActual(){
        this.fecha=new Date();
    }

    public Pedido() {
    }

    public Pedido(String id_pedido, Date fecha, int impuesto, int totalped, String estadop) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.totalped = totalped;
        this.estadop = estadop;
        // this.usuario = usuario;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotalped() {
        return totalped;
    }

    public void setTotalped(int totalped) {
        this.totalped = totalped;
    }

    public String getEstadop() {
        return estadop;
    }

    public void setEstadop(String estadop) {
        this.estadop = estadop;
    }

    //public Usuario getUsuario() {
    //    return usuario;
    //}
//
    //public void setUsuario(Usuario usuario) {
    //    this.usuario = usuario;
    //}

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido='" + id_pedido + '\'' +
                ", fecha='" + fecha + '\'' +
                ", impuesto=" + impuesto +
                ", totalped=" + totalped +
                ", estadop='" + estadop + '\'' +
                // ", usuario=" + usuario +
                '}';
    }
}
