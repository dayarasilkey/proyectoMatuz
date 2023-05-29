package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Productos;
import com.example.matizu.Servicio.ServicioProducto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class ControladorProducto {
    private ServicioProducto servicio;

    public ControladorProducto(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarProductos")
    public ArrayList<Productos> ListarProductos(){
        return servicio.ListarProductos();
    }

    @GetMapping ("/buscaridpro/{id_entrega}")
    Productos buscaridpro(@PathVariable("id_producto")String id_producto){
        return  servicio.buscaridpro(id_producto);
    }

    @GetMapping ("/buscarCodigoPro/{codProducto}")
    public ArrayList<Productos> buscarCodigoPro(@PathVariable("codProducto")String p){
        return servicio.buscarCodigoPro(p);
    }

    @GetMapping ("/buscarNombrepro/{nombreProd}")
    public ArrayList<Productos> buscarNombrepro(@PathVariable("nombreProd")String n){
        return servicio.buscarNombrepro(n);
    }

    @GetMapping ("/buscarDescripcionpro/{descripcion}")
    public ArrayList<Productos> buscarDescripcionpro(@PathVariable("descripcion")String d){
        return servicio.buscarDescripcionpro(d);
    }

    @PostMapping("/agregarProducto")
    public  String agregarProducto(@RequestBody Productos productos){
        return servicio.agregarProducto(productos);
    }

    @PutMapping("/actualizarProducto")
    public  String actualizarProducto(@RequestBody Productos productos){
        return servicio.actualizarProducto(productos);
    }

    @DeleteMapping("/eliminarProducto/{Id_producto}")
    public String eliminarProducto(@PathVariable("Id_producto") String Id_producto){
        return servicio.eliminarProducto(Id_producto);
    }
}
