package com.example.matizu.Controlador;

import com.example.matizu.Entidad.DetallePedido;
import com.example.matizu.Servicio.ServicioDetallePedido;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorDetallePedido {
    private ServicioDetallePedido servicio;

    public ControladorDetallePedido(ServicioDetallePedido servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarDetallePed")
    public ArrayList<DetallePedido> ListarDetallePed(){
        return servicio.ListarDetallePed();
    }

    @GetMapping ("/buscarDetallePed/{idDetallePedido}")
    DetallePedido buscarDetallePed(@PathVariable("idDetallePedido")Integer idDetallePedido){
        return  servicio.buscarDetallePed(idDetallePedido);
    }

    @PostMapping("/agregarDetallePed")
    public  String agregarDetallePed(@RequestBody DetallePedido detallePedido){
        return servicio.agregarDetallePed(detallePedido);
    }

    @PutMapping("/actualizarDetallePed")
    public  String actualizarDetallePed(@RequestBody DetallePedido detallePedido){
        return servicio.actualizarDetallePed(detallePedido);
    }

    @DeleteMapping("/eliminarDetallePed/{idDetallePedido}")
    public String eliminarDetallePed(@PathVariable("idDetallePedido") Integer idDetallePedido){
        return servicio.eliminarDetallePed(idDetallePedido);
    }
}
