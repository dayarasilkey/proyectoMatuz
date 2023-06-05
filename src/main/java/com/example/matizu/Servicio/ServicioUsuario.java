package com.example.matizu.Servicio;

import com.example.matizu.Entidad.Usuario;
import com.example.matizu.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorio) {
        this.repositorioUsuario = repositorio;
    }

    public ArrayList<Usuario> ListarUsuario() {
        return (ArrayList<Usuario>) repositorioUsuario.findAll();
    }

    public Usuario buscarUsuario(Integer id_usuario) {
        if (repositorioUsuario.findById(id_usuario).isPresent())
            return repositorioUsuario.findById(id_usuario).get();
        else return null;
    }

    public ArrayList<Usuario> buscarNombreu(String nombre) {
        return repositorioUsuario.findByNombre(nombre);
    }

    public ArrayList<Usuario> buscarApellidou(String apellido) {
        return repositorioUsuario.findByApellido(apellido);
    }

    public ArrayList<Usuario> buscarNumdocumentou(String numdocumento) {
        return repositorioUsuario.findByNumdocumento(numdocumento);
    }

    public ArrayList<Usuario> buscarDireccionu(String direccion) {
        return repositorioUsuario.findByDireccion(direccion);
    }

    public ArrayList<Usuario> buscarTelefonou(String telefono) {
        return repositorioUsuario.findByTelefono(telefono);
    }

    public ArrayList<Usuario> buscarEmailu(String email) {
        return repositorioUsuario.findByEmail(email);
    }

    public ArrayList<Usuario> buscarContraseñau(String contraseña) {
        return repositorioUsuario.findByContraseña(contraseña);
    }

    public String agregarUsuario(Usuario usuario) {

        if (repositorioUsuario.findById(usuario.getId_usuario()).isPresent())
            return "El Usuario ya se encuentra registrado";
        else
            repositorioUsuario.save(usuario);
        return "El Usuario se registro exitosamente.";

    }

    public String actualizarUsuario(Usuario usuario) {

        if (repositorioUsuario.findById(usuario.getId_usuario()).isPresent()) {
            repositorioUsuario.save(usuario);
            return "El Usuario se actualizo exitosamente.";
        } else {
            return "El Usuario no se encuentra registrado";

        }
    }

    public String eliminarUsuario(Integer id_usuario) {
        if (repositorioUsuario.findById(id_usuario).isPresent()) {
            repositorioUsuario.deleteById(id_usuario);
            return "Usuario eliminado";
        } else {
            return "El Usuario no se encuentra registrado";
        }
    }


    //public boolean validarRegistro(Usuario usuario) {
//
    //    // Verificar si el correo electrónico ya existe en la base de datos
    //    boolean correoExistente=repositorioUsuario.existsByCorreocontra(usuario.getEmail(),usuario.getContraseña());
    //    return !correoExistente;
//
    //}
}


