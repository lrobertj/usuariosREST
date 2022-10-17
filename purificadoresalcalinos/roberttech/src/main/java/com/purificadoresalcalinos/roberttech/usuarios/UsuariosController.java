package com.purificadoresalcalinos.roberttech.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosS) {
        this.usuariosService = usuariosS;
    }

    @RequestMapping(path="{id}")
    public ResponseEntity<Usuarios> getUserPorId(@PathVariable("id") Long id){
        Optional<Usuarios> optionalUsuarios = usuariosService.getUsuarioPorId(id);
        if (optionalUsuarios.isPresent())
            return ResponseEntity.ok(optionalUsuarios.get());
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(path="/login")
    public ResponseEntity<Usuarios> getByUserAndPassword (@RequestParam("user") String user, @RequestParam("password") String password){
        Optional<Usuarios> optionalUsuarios = usuariosService.getUsuarioAndPassword(user, password);
        if (optionalUsuarios.isPresent())
            return ResponseEntity.ok(optionalUsuarios.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Usuarios> getuser(){
        return usuariosService.getUsuarios();
    }

    //Recibe de UsuariosService newUsuario
    @PostMapping
    public void insertNewUsuario(@RequestBody Usuarios newUsuario){
        usuariosService.addNewUsuario(newUsuario);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
        usuariosService.deleteUser(id);
    }

    @PutMapping(path = "{usuarioId}")
    public void updateUsuario(
            @PathVariable("usuarioId") Long usuarioId,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) Integer edad,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String urlpicture,
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String password){
        usuariosService.updateUser(usuarioId, nombre, apellidos, edad, email, urlpicture, user, password);
    }
}
