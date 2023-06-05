package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Integer> {
    ArrayList<Proveedor> findByNombreProvedor(String nombreProvedor);
    ArrayList<Proveedor> findByTelefono(String telefono);
    ArrayList<Proveedor> findByEmail(String email);

}
