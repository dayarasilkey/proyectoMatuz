package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, String> {
    ArrayList<Categoria> findByNombreCat(String nombreCat);
    ArrayList<Categoria> findByTipoCat(String tipoCat);
    ArrayList<Categoria> findByDescripcionCat(String descripcionCat);
}
