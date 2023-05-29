package com.example.matizu.Controlador;

import com.example.matizu.Entidad.DetalleProducto;
import com.example.matizu.Servicio.ServicioDetalleProducto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContoladorDetalleProducto {
    private ServicioDetalleProducto servicio;

    public ContoladorDetalleProducto(ServicioDetalleProducto servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarDetallepro")
    public ArrayList<DetalleProducto> ListarDetallepro(){
        return servicio.ListarDetallepro();
    }

    @GetMapping ("/buscarDetallepro/{id_detallepro}")
    DetalleProducto buscarDetallepro(@PathVariable("id_detallepro")String id_detallepro){
        return  servicio.buscarDetallepro(id_detallepro);
    }

    @GetMapping ("/buscarDescripcionDetallePro/{descripcionDetallePro}")
    public ArrayList<DetalleProducto> buscarDescripciondetalpro(@PathVariable("descripcionDetallePro")String d){
        return servicio.buscarDescripciondetalpro(d);
    }

    @PostMapping("/agregarDetallepro")
    public  String agregarDetallepro(@RequestBody DetalleProducto detalleProducto){
        return servicio.agregarDetallepro(detalleProducto);
    }

    @PutMapping("/actualizarDetallepro")
    public  String actualizarDetallepro(@RequestBody DetalleProducto detalleProducto){
        return servicio.actualizarDetallepro(detalleProducto);
    }

    @DeleteMapping("/eliminarDetallepro/{id_detallepro}")
    public String eliminarDetallepro(@PathVariable("id_detallepro") String id_detallepro){
        return servicio.eliminarDetallepro(id_detallepro);
    }
}
