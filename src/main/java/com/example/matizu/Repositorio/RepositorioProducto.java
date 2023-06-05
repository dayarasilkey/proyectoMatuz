package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioProducto extends JpaRepository<Productos, Integer> {
    ArrayList<Productos> findByNombreProd(String nombreProd);
    ArrayList<Productos> findByDescripcion(String descripcion);
}
