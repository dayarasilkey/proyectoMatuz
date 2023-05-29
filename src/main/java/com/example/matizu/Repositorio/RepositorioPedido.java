package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, String> {
    ArrayList<Pedido> findByEstadop(String estadop);

}
