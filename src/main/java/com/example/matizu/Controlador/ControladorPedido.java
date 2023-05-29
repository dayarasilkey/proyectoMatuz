package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Pedido;
import com.example.matizu.Servicio.ServicioPedido;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorPedido {

    private ServicioPedido serviciopedido;

    public ControladorPedido(ServicioPedido serviciopedido) {
        this.serviciopedido = serviciopedido;
    }

    @GetMapping("/listarPedido")
    public ArrayList<Pedido> ListarPedido(){
        return serviciopedido.ListarPedido();
    }
    @GetMapping ("/buscarPed/{id_pedido}")
    Pedido buscarRol(@PathVariable("id_pedido")String id_pedido){
        return  serviciopedido.buscarPed(id_pedido);
    }

    //@GetMapping ("/buscarFecha/{fecha}")
    //public ArrayList<Pedido> buscarFecha(@PathVariable("fecha")String f){
    //    return servicio.buscarFecha(f);
    //}

    @GetMapping ("/buscarEstadop/{estadop}")
    public ArrayList<Pedido> buscarEstadop(@PathVariable("estadop")String e){
        return serviciopedido.buscarEstadop(e);
    }

    @PostMapping("/agregarPed")
    public  String agregarPed(@RequestBody Pedido pedido){
        return serviciopedido.agregarPed(pedido);
    }

    @PutMapping("/actualizarPed")
    public  String actualizarRol(@RequestBody Pedido pedido){
        return serviciopedido.actualizarPed(pedido);
    }

    @DeleteMapping("/eliminarPed/{id_pedido}")
    public String eliminarPed(@PathVariable("id_pedido") String id_pedido){
        return serviciopedido.eliminarPed(id_pedido);
    }


}
