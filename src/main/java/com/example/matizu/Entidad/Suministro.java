package com.example.matizu.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Suministro")
public class Suministro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSuministro;
    @Column(nullable = false, length= 50)
    private String descripcionSuministro;

    @Column(nullable = false, length= 30)
    private String nombreSum;

    @Column(nullable = false, name = "stockSum", length = (100))
    private Integer stockSum;


    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @JsonIgnore
    private Productos productos;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @JsonIgnore
    private Proveedor proveedor;

    public Suministro() {
    }

    public Suministro(Integer idSuministro, String descripcionSuministro, String nombreSum, Integer stockSum) {
        this.idSuministro = idSuministro;
        this.descripcionSuministro = descripcionSuministro;
        this.nombreSum = nombreSum;
        this.stockSum = stockSum;
    }

    public Integer getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(Integer idSuministro) {
        this.idSuministro = idSuministro;
    }

    public String getDescripcionSuministro() {
        return descripcionSuministro;
    }

    public void setDescripcionSuministro(String descripcionSuministro) {
        this.descripcionSuministro = descripcionSuministro;
    }

    public String getNombreSum() {
        return nombreSum;
    }

    public void setNombreSum(String nombreSum) {
        this.nombreSum = nombreSum;
    }

    public Integer getStockSum() {
        return stockSum;
    }

    public void setStockSum(Integer stockSum) {
        this.stockSum = stockSum;
    }

    @Override
    public String toString() {
        return "Suministro{" +
                "idSuministro='" + idSuministro + '\'' +
                ", descripcionSuministro='" + descripcionSuministro + '\'' +
                ", nombreSum='" + nombreSum + '\'' +
                ", stockSum=" + stockSum +
                '}';
    }
}
