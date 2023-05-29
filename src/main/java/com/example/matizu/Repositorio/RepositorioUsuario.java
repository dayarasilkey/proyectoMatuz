package com.example.matizu.Repositorio;

import com.example.matizu.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {

    ArrayList<Usuario> findByNombre(String nombre);
    ArrayList<Usuario> findByApellido(String apellido);
    ArrayList<Usuario> findByNumdocumento(String numdocumento);
    ArrayList<Usuario> findByDireccion(String direccion);
    ArrayList<Usuario> findByTelefono(String telefono);
    ArrayList<Usuario> findByEmail(String email);
    ArrayList<Usuario> findByContraseña(String contraseña);


}

