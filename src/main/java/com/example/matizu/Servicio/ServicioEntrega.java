package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Entrega;
import com.example.matizu.Repositorio.RepositorioEntrega;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ServicioEntrega {

    private RepositorioEntrega repositorio;

    public ServicioEntrega(RepositorioEntrega repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Entrega> ListarEntrega() {
        return (ArrayList<Entrega>) repositorio.findAll();
    }

    public Entrega buscarEnt(String id_entrega) {
        if (repositorio.findById(id_entrega).isPresent())
            return repositorio.findById(id_entrega).get();
        else return null;
    }

    //public ArrayList<Entrega> buscarFechae(Date fechae) {
    //    return repositorio.findByFechae(fechae);
    //}

    public String agregarEnt(Entrega entrega) {

        if (repositorio.findById(entrega.getId_entrega()).isPresent())
            return "La entrega ya se encuentra registrado";
        else
            repositorio.save(entrega);
        return "La etrega se registro exitosamente.";

    }

    public String actualizarEnt(Entrega entrega) {

        if (repositorio.findById(entrega.getId_entrega()).isPresent()){
            repositorio.save(entrega);
            return "La Entrega se actualizo exitosamente.";
        }
        else{
            return "La entrega no se encuentra registrado";

        }
    }

    public String eliminarEnt(String id_entrega) {
        if (repositorio.findById(id_entrega).isPresent()) {
            repositorio.deleteById(id_entrega);
            return "Entrega eliminada";
        } else {
            return "La Entrega no se encuentra registrada";
        }
    }

}
