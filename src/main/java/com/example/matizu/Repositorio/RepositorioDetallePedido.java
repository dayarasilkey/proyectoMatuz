package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetallePedido extends JpaRepository<DetallePedido, String> {

}
