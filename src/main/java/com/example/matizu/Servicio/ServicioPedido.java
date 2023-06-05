package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Pedido;
import com.example.matizu.Repositorio.RepositorioPedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioPedido {

    private RepositorioPedido repositorio;

    public ServicioPedido(RepositorioPedido repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Pedido> ListarPedido() {
        return (ArrayList<Pedido>) repositorio.findAll();
    }

    public Pedido buscarPed(Integer id_pedido) {
        if (repositorio.findById(id_pedido).isPresent())
            return repositorio.findById(id_pedido).get();
        else return null;
    }

    //public ArrayList<Pedido> buscarFecha(String fecha) {
      //  return repositorio.findByFecha(fecha);
    //}

    public ArrayList<Pedido> buscarEstadop(String estadop) {
        return repositorio.findByEstadop(estadop);
    }

    public String agregarPed(Pedido pedido) {

        if (repositorio.findById(pedido.getId_pedido()).isPresent())
            return "El Pedido ya se encuentra registrado";
        else
            repositorio.save(pedido);
        return "El Pedido se registro exitosamente.";

    }

    public String actualizarPed(Pedido pedido) {

        if (repositorio.findById(pedido.getId_pedido()).isPresent()){
            repositorio.save(pedido);
            return "El Pedido se actualizo exitosamente.";
        }
        else{
            return "El Pedido no se encuentra registrado";

        }
    }

    public String eliminarPed(Integer id_pedido) {
        if (repositorio.findById(id_pedido).isPresent()) {
            repositorio.deleteById(id_pedido);
            return "Pedido eliminado";
        } else {
            return "El Pedido no se encuentra registrado";
        }
    }

    //public List<Object[]> Buscarpedidousu(String usu){
    //    return  repositorio.findPedidousuario(usu);
    //}

    //public List<Object[]> Buscarpedidoent(String ent){
     //   return  repositorio.findPedidoEntrga(ent);
    //}

}
