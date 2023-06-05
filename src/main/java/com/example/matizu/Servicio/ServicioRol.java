package com.example.matizu.Servicio;
import com.example.matizu.Entidad.Rol;
import com.example.matizu.Repositorio.RepositorioRol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioRol {
    private RepositorioRol repositorio;

    public ServicioRol(RepositorioRol repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Rol> ListarRol() {
        return (ArrayList<Rol>) repositorio.findAll();
    }

    public Rol buscarRol(Integer id_rol) {
        if (repositorio.findById(id_rol).isPresent())
            return repositorio.findById(id_rol).get();
        else return null;
    }

    public ArrayList<Rol> buscarNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public ArrayList<Rol> buscarDescripcion(String descripcion) {
        return repositorio.findByDescripcion(descripcion);
    }

    public ArrayList<Rol> buscarEstado(String estado) {
        return repositorio.findByEstado(estado);
    }

    public String agregarRol(Rol rol) {

        if (repositorio.findById(rol.getId_rol()).isPresent())
            return "El Rol ya se encuentra registrado";
        else
            repositorio.save(rol);
        return "El Rol se registro exitosamente.";

    }

    public String actualizarRol(Rol rol) {

        if (repositorio.findById(rol.getId_rol()).isPresent()){
            repositorio.save(rol);
            return "El Rol se actualizo exitosamente.";
        }
        else{
            return "El Rol no se encuentra registrado";

        }
    }

    public String eliminarRol(Integer id_rol) {
        if (repositorio.findById(id_rol).isPresent()) {
            repositorio.deleteById(id_rol);
            return "Rol eliminado";
        } else {
            return "El Rol no se encuentra registrado";
        }
    }
}
