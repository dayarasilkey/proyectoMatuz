package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Entrega;
import com.example.matizu.Servicio.ServicioEntrega;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorEntrega {
    private ServicioEntrega servicio;

    public ControladorEntrega(ServicioEntrega servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarEntrega")
    public ArrayList<Entrega> ListarEntrega(){
        return servicio.ListarEntrega();
    }

    @GetMapping ("/buscarEnt/{id_entrega}")
    Entrega buscarEnt(@PathVariable("id_entrega")Integer id_entrega){
        return  servicio.buscarEnt(id_entrega);
    }


    @PostMapping("/agregarEnt")
    public  String agregarEnt(@RequestBody Entrega entrega){
        return servicio.agregarEnt(entrega);
    }

    @PutMapping("/actualizarEnt")
    public  String actualizarEnt(@RequestBody Entrega entrega){
        return servicio.actualizarEnt(entrega);
    }

    @DeleteMapping("/eliminarEnt/{id_entrega}")
    public String eliminarEnt(@PathVariable("id_entrega") Integer id_entrega){
        return servicio.eliminarEnt(id_entrega);
    }
}
