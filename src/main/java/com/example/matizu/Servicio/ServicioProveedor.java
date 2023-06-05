package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Proveedor;
import com.example.matizu.Repositorio.RepositorioProveedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioProveedor {
    private RepositorioProveedor repositorio;

    public ServicioProveedor(RepositorioProveedor repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Proveedor> ListarProveedor() {
        return (ArrayList<Proveedor>) repositorio.findAll();
    }

    public Proveedor buscarProv(Integer id_proveedor) {
        if (repositorio.findById(id_proveedor).isPresent())
            return repositorio.findById(id_proveedor).get();
        else return null;
    }

    public ArrayList<Proveedor> buscarnombrepro(String nombreProvedor) {
        return repositorio.findByNombreProvedor(nombreProvedor);
    }

    public ArrayList<Proveedor> buscartelefonopro(String telefono) {
        return repositorio.findByTelefono(telefono);
    }

    public ArrayList<Proveedor> buscaremailpro(String email) {
        return repositorio.findByEmail(email);
    }

    public String agregarProv(Proveedor proveedor) {

        if (repositorio.findById(proveedor.getId_proveedor()).isPresent())
            return "El Provedor ya se encuentra registrado";
        else
            repositorio.save(proveedor);
        return "El Provedor se registro exitosamente.";

    }

    public String actualizarProv(Proveedor proveedor) {

        if (repositorio.findById(proveedor.getId_proveedor()).isPresent()){
            repositorio.save(proveedor);
            return "El Provedor se actualizo exitosamente.";
        }
        else{
            return "El Provedor no se encuentra registrado";

        }
    }

    public String eliminarProve(Integer id_proveedor) {
        if (repositorio.findById(id_proveedor).isPresent()) {
            repositorio.deleteById(id_proveedor);
            return "Proveedor eliminado";
        } else {
            return "El Proveedor no se encuentra registrado";
        }
    }
}
