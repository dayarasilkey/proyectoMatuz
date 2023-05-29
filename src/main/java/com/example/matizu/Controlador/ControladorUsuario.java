package com.example.matizu.Controlador;

import com.example.matizu.Entidad.Usuario;
import com.example.matizu.Servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorUsuario {

    private ServicioUsuario servicio;

    public ControladorUsuario(ServicioUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarUsuario")
    public ArrayList<Usuario> ListarUsuario(){
        return servicio.ListarUsuario();
    }

    @GetMapping ("/buscarUsuario/{id_usuario}")
    Usuario buscarUsuario(@PathVariable("id_usuario")String id_usuario){
        return  servicio.buscarUsuario(id_usuario);
    }

    @GetMapping ("/buscarNombreu/{nombre}")
    public ArrayList<Usuario> buscarNombre(@PathVariable("nombre")String n){
        return servicio.buscarNombreu(n);
    }

    @GetMapping ("/buscarApellidou/{apellido}")
    public ArrayList<Usuario> buscarApellido(@PathVariable("apellido")String a){
        return servicio.buscarApellidou(a);
    }

    @GetMapping ("/buscarNumdocumentou/{numdocumento}")
    public ArrayList<Usuario> buscarNumdocumento(@PathVariable("numdocumento")String u){
        return servicio.buscarNumdocumentou(u);
    }

    @GetMapping ("/buscarDireccionu/{direccion}")
    public ArrayList<Usuario> buscarDireccion(@PathVariable("direccion")String d){
        return servicio.buscarDireccionu(d);
    }

    @GetMapping ("/buscarTelefonou/{telefono}")
    public ArrayList<Usuario> buscarTelefono(@PathVariable("telefono")String t){
        return servicio.buscarTelefonou(t);
    }

    @GetMapping ("/buscarEmailu/{email}")
    public ArrayList<Usuario> buscarEmail(@PathVariable("email")String e){
        return servicio.buscarEmailu(e);
    }

    @GetMapping ("/buscarContraseñau/{contraseña}")
    public ArrayList<Usuario> buscarContraseña(@PathVariable("contraseña")String c){
        return servicio.buscarContraseñau(c);
    }

    @PostMapping("/agregarUsuario")
    public  String agregarUsuario(@RequestBody Usuario usuario){
        return servicio.agregarUsuario(usuario);
    }

    @PutMapping("/actualizarUsuario")
    public  String actualizarUsuario(@RequestBody Usuario usuario){
        return servicio.actualizarUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario/{id_usuario}")
    public String eliminarUsuario(@PathVariable("id_usuario") String id_usuario){
        return servicio.eliminarUsuario(id_usuario);
    }


}
