package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Categoria;
import com.example.matizu.Repositorio.RepositorioCategoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioCategoria {
    private RepositorioCategoria repositorio;

    public ServicioCategoria(RepositorioCategoria repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Categoria> ListarCategoria() {
        return (ArrayList<Categoria>) repositorio.findAll();
    }

    public Categoria buscaridcat(Integer id_categoria) {
        if (repositorio.findById(id_categoria).isPresent())
            return repositorio.findById(id_categoria).get();
        else return null;
    }

    public ArrayList<Categoria> buscarombreCat(String nombreCat) {
        return repositorio.findByNombreCat(nombreCat);
    }

    public ArrayList<Categoria> buscarTipoCat(String tipoCat) {
        return repositorio.findByTipoCat(tipoCat);
    }

    public ArrayList<Categoria> buscarDescripcionCat(String descripcionCat) {
        return repositorio.findByDescripcionCat(descripcionCat);
    }

    public String agregarCategoria(Categoria categoria) {

        if (repositorio.findById(categoria.getId_categoria()).isPresent())
            return "La Categoria ya se encuentra registrado";
        else
            repositorio.save(categoria);
        return "La Categoria se registro exitosamente.";

    }

    public String actualizarCategoria(Categoria categoria) {

        if (repositorio.findById(categoria.getId_categoria()).isPresent()){
            repositorio.save(categoria);
            return "La Categoria se actualizo exitosamente.";
        }
        else{
            return "La Categoria no se encuentra registrado";

        }
    }

    public String eliminarCategoria(Integer id_categoria) {
        if (repositorio.findById(id_categoria).isPresent()) {
            repositorio.deleteById(id_categoria);
            return "La categoria ha sido eliminado";
        } else {
            return "El categoria no se encuentra registrado";
        }
    }
}
