package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Usuario;
import com.example.matizu.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorio;

    public ServicioUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Usuario> ListarUsuario() {
        return (ArrayList<Usuario>) repositorio.findAll();
    }

    public Usuario buscarUsuario(String id_usuario) {
        if (repositorio.findById(id_usuario).isPresent())
            return repositorio.findById(id_usuario).get();
        else return null;
    }

    public ArrayList<Usuario> buscarNombreu(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public ArrayList<Usuario> buscarApellidou(String apellido) {
        return repositorio.findByApellido(apellido);
    }

    public ArrayList<Usuario> buscarNumdocumentou(String numdocumento) {
        return repositorio.findByNumdocumento(numdocumento);
    }

    public ArrayList<Usuario> buscarDireccionu(String direccion) {
        return repositorio.findByDireccion(direccion);
    }

    public ArrayList<Usuario> buscarTelefonou(String telefono) {
        return repositorio.findByTelefono(telefono);
    }

    public ArrayList<Usuario> buscarEmailu(String email) {
        return repositorio.findByEmail(email);
    }

    public ArrayList<Usuario> buscarContraseñau(String contraseña) {
        return repositorio.findByContraseña(contraseña);
    }

    public String agregarUsuario(Usuario usuario) {

        if (repositorio.findById(usuario.getId_usuario()).isPresent())
            return "El Usuario ya se encuentra registrado";
        else
            repositorio.save(usuario);
        return "El Usuario se registro exitosamente.";

    }

    public String actualizarUsuario(Usuario usuario) {

        if (repositorio.findById(usuario.getId_usuario()).isPresent()) {
            repositorio.save(usuario);
            return "El Usuario se actualizo exitosamente.";
        } else {
            return "El Usuario no se encuentra registrado";

        }
    }

    public String eliminarUsuario(String id_usuario) {
        if (repositorio.findById(id_usuario).isPresent()) {
            repositorio.deleteById(id_usuario);
            return "Usuario eliminado";
        } else {
            return "El Usuario no se encuentra registrado";
        }
    }

}
