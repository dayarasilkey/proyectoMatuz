package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEntrega extends JpaRepository<Entrega, Integer>{

}
