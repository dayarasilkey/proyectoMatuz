package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Proveedor;
import com.example.matizu.Servicio.ServicioProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorProveedor {
    private ServicioProveedor servicio;

    public ControladorProveedor(ServicioProveedor servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarProveedor")
    public ArrayList<Proveedor> ListarProveedor(){
        return servicio.ListarProveedor();
    }

    @GetMapping ("/buscarProv/{id_proveedor}")
    Proveedor buscarProv(@PathVariable("id_proveedor")String id_proveedor){
        return  servicio.buscarProv(id_proveedor);
    }

    @GetMapping ("/buscarnombreprov/{nombreProvedor}")
    public ArrayList<Proveedor> buscarnombrepro(@PathVariable("nombreProvedor")String p){
        return servicio.buscarnombrepro(p);
    }

    @GetMapping ("/buscartelefonoprov/{telefono}")
    public ArrayList<Proveedor> buscartelefonopro(@PathVariable("telefono")String b){
        return servicio.buscartelefonopro(b);
    }

    @GetMapping ("/buscaremailprov/{email}")
    public ArrayList<Proveedor> buscaremailpro(@PathVariable("email")String e){
        return servicio.buscaremailpro(e);
    }

    @PostMapping("/agregarProv")
    public  String agregarProv(@RequestBody Proveedor proveedor){
        return servicio.agregarProv(proveedor);
    }

    @PutMapping("/actualizarProv")
    public  String actualizarProv(@RequestBody Proveedor proveedor){
        return servicio.actualizarProv(proveedor);
    }

    @DeleteMapping("/eliminarProve/{id_proveedor}")
    public String eliminarProve(@PathVariable("id_proveedor") String id_proveedor){
        return servicio.eliminarProve(id_proveedor);
    }
}
