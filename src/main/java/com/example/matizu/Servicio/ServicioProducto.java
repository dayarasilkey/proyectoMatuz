package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Productos;
import com.example.matizu.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServicioProducto {
    private RepositorioProducto repositorio;

    public ServicioProducto(RepositorioProducto repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Productos> ListarProductos() {
        return (ArrayList<Productos>) repositorio.findAll();
    }

    public Productos buscaridpro(Integer id_producto) {
        if (repositorio.findById(id_producto).isPresent())
            return repositorio.findById(id_producto).get();
        else return null;
    }


    public ArrayList<Productos> buscarNombrepro(String nombreProd) {
        return repositorio.findByNombreProd(nombreProd);
    }
    public ArrayList<Productos> buscarDescripcionpro(String descripcion) {
        return repositorio.findByDescripcion(descripcion);
    }

    public String agregarProducto(Productos productos) {

        if (repositorio.findById(productos.getId_producto()).isPresent())
            return "El producto ya se encuentra registrado";
        else
            repositorio.save(productos);
        return "El producto se registro exitosamente.";

    }

    public String actualizarProducto(Productos productos) {

        if (repositorio.findById(productos.getId_producto()).isPresent()){
            repositorio.save(productos);
            return "El producto se actualizo exitosamente.";
        }
        else{
            return "El producto no se encuentra registrado";

        }
    }

    public String eliminarProducto(Integer Id_producto) {
        if (repositorio.findById(Id_producto).isPresent()) {
            repositorio.deleteById(Id_producto);
            return "El producto del pedido ha sido eliminado";
        } else {
            return "El producto del pedido  no se encuentra registrado";
        }
    }

}
