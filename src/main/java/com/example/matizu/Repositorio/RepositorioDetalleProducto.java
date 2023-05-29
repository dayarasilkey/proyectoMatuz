package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RepositorioDetalleProducto extends JpaRepository<DetalleProducto, String> {
    ArrayList<DetalleProducto> findByDescripcionDetallePro(String descripcionDetallePro);
}
