package com.example.matizu.Servicio;

import com.example.matizu.Entidad.DetalleProducto;
import com.example.matizu.Repositorio.RepositorioDetalleProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioDetalleProducto {
    private RepositorioDetalleProducto repositorio;

    public ServicioDetalleProducto(RepositorioDetalleProducto repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<DetalleProducto> ListarDetallepro() {
        return (ArrayList<DetalleProducto>) repositorio.findAll();
    }

    public DetalleProducto buscarDetallepro(String id_detallepro) {
        if (repositorio.findById(id_detallepro).isPresent())
            return repositorio.findById(id_detallepro).get();
        else return null;
    }

    public ArrayList<DetalleProducto> buscarDescripciondetalpro(String descripcionDetallePro) {
        return repositorio.findByDescripcionDetallePro(descripcionDetallePro);
    }

    public String agregarDetallepro(DetalleProducto detalleProducto) {

        if (repositorio.findById(detalleProducto.getdescripcionDetallePro()).isPresent())
            return "El Detalle  del producto  ya se encuentra registrado";
        else
            repositorio.save(detalleProducto);
        return "El Detalle del producto se registro exitosamente.";

    }

    public String actualizarDetallepro(DetalleProducto detalleProducto) {

        if (repositorio.findById(detalleProducto.getId_detallepro()).isPresent()){
            repositorio.save(detalleProducto);
            return "El Detalle producto se actualizo exitosamente.";
        }
        else{
            return "El Detalle producto no se encuentra registrado";

        }
    }

    public String eliminarDetallepro(String id_detallepro) {
        if (repositorio.findById(id_detallepro).isPresent()) {
            repositorio.deleteById(id_detallepro);
            return "Detalle de pr[oducto eliminado";
        } else {
            return "El Detalle de producto no se encuentra registrado";
        }
    }
}
