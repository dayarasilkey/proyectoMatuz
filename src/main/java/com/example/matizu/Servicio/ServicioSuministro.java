package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Suministro;
import com.example.matizu.Repositorio.RepositorioSuministro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioSuministro {
    private RepositorioSuministro repositorio;

    public ServicioSuministro(RepositorioSuministro repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Suministro> ListarSuministro() {
        return (ArrayList<Suministro>) repositorio.findAll();
    }

    public Suministro buscarSumistro(Integer idSuministro) {
        if (repositorio.findById(Integer.valueOf(String.valueOf(idSuministro))).isPresent())
            return repositorio.findById(idSuministro).get();
        else return null;
    }

    public ArrayList<Suministro> buscarDescripcionSumi(String descripcionSuministro) {
        return repositorio.findBydescripcionSuministro(descripcionSuministro);
    }

    public ArrayList<Suministro> buscarNombreSumi(String nombreSum) {
        return repositorio.findBynombreSum(nombreSum);
    }

    public String agregarSuministro(Suministro suministro) {

        if (repositorio.findById(suministro.getIdSuministro()).isPresent())
            return "El Suministro ya se encuentra registrado";
        else
            repositorio.save(suministro);
            return "El Suministro se registro exitosamente.";

    }

    public String actualizarSuministro(Suministro suministro) {

        if (repositorio.findById(suministro.getIdSuministro()).isPresent()){
            repositorio.save(suministro);
            return "El Suministro se actualizo exitosamente.";
        }
        else{
            return "El Suministro no se encuentra registrado";

        }
    }

    public String eliminarSuministro(Integer idSuministro) {
        if (repositorio.findById(Integer.valueOf(String.valueOf(idSuministro))).isPresent()) {
            repositorio.deleteById(idSuministro);
            return "Suministro eliminado";
        } else {
            return "El Suministro no se encuentra registrado";
        }
    }


    public List<Object[]>buscarStock(Integer dato){
        return repositorio.findBystocksum(dato);
    }
}
