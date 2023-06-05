package com.example.matizu.Servicio;

import com.example.matizu.Entidad.DetallePedido;
import com.example.matizu.Repositorio.RepositorioDetallePedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioDetallePedido {
    private RepositorioDetallePedido repositorio;

    public ServicioDetallePedido(RepositorioDetallePedido repositorio) {
        this.repositorio = repositorio;
    }
    public ArrayList<DetallePedido> ListarDetallePed() {
        return (ArrayList<DetallePedido>) repositorio.findAll();
    }

    public DetallePedido buscarDetallePed(Integer idDetallePedido) {
        if (repositorio.findById(idDetallePedido).isPresent())
            return repositorio.findById(idDetallePedido).get();
        else return null;
    }

    public String agregarDetallePed(DetallePedido detallePedido) {

        if (repositorio.findById(detallePedido.getIdDetallePedido()).isPresent())
            return "El detalle del pedido ya se encuentra registrado";
        else
            repositorio.save(detallePedido);
        return "El detalle del pedido se registro exitosamente.";

    }

    public String actualizarDetallePed(DetallePedido detallePedido) {

        if (repositorio.findById(detallePedido.getIdDetallePedido()).isPresent()){
            repositorio.save(detallePedido);
            return "El detalle del pedido se actualizo exitosamente.";
        }
        else{
            return "El detalle del pedido no se encuentra registrado";

        }
    }

    public String eliminarDetallePed(Integer idDetallePedido) {
        if (repositorio.findById(idDetallePedido).isPresent()) {
            repositorio.deleteById(idDetallePedido);
            return "El detalle del pedido ha sido eliminado";
        } else {
            return "El detalle del pedido  no se encuentra registrado";
        }
    }
}
