package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Suministro;
import com.example.matizu.Servicio.ServicioSuministro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContoladorSuministro {
    private ServicioSuministro servicio;

    public ContoladorSuministro(ServicioSuministro servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarSuministro")
    public ArrayList<Suministro> ListarSuministro(){
        return servicio.ListarSuministro();
    }

    @GetMapping ("/buscarSumistro/{idSuministro}")
    Suministro buscarSumistro(@PathVariable("idSuministro")Integer idSuministro){
        return  servicio.buscarSumistro(idSuministro);
    }

    @GetMapping ("/buscardescripcionSuministro/{descripcionSuministro}")
    public ArrayList<Suministro> buscardescripcionSuministro(@PathVariable("descripcionDetallePro")String d){
        return servicio.buscarDescripcionSumi(d);
    }


    @GetMapping ("/buscarNombreSumi/{nombreSum}")
    public ArrayList<Suministro> buscarNombreSumi(@PathVariable("nombreSum")String n){
        return servicio.buscarNombreSumi(n);
    }

    @PostMapping("/agregarSuministro")
    public  String agregarSuministro(@RequestBody Suministro suministro){
        return servicio.agregarSuministro(suministro);
    }

    @PutMapping("/actualizarSuministro")
    public  String actualizarSuministro(@RequestBody Suministro suministro){
        return servicio.actualizarSuministro(suministro);
    }

    @DeleteMapping("/eliminarSuministro/{idSuministro}")
    public String eliminarSuministro(@PathVariable("idSuministro") Integer idSuministro){
        return servicio.eliminarSuministro(idSuministro);
    }
}
