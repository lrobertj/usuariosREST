package com.purificadoresalcalinos.roberttech.usuarios;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuariosService {


    private final UsuariosRepositorio usuariosRepositorio;

    //Realiza operaciones desde CommandLine p.ej. insertar usuarios
    public UsuariosService(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }




    public List<Usuarios> getUsuarios() {
        return usuariosRepositorio.findAll();
    }

    //Servicio que recibe de Usuarios newUsuario
    public void addNewUsuario(Usuarios newUsuario) {
//        Revisa que el email no este repetido
        Optional<Usuarios> usuariosOptional = usuariosRepositorio.findByUsuariosEmail(newUsuario.getEmail());
        if (usuariosOptional.isPresent()) {
            throw new IllegalStateException("Email ya está presente");
        }
        System.out.println(newUsuario);
        usuariosRepositorio.save(newUsuario);
    }

    public void deleteUser(Long id) {
        boolean existe = usuariosRepositorio.existsById(id);
        if (!existe){
            throw new IllegalStateException("El id del usuario no existe");
        }
        usuariosRepositorio.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String nombre, String apellidos, Integer edad, String email, String urlpicture, String user, String password) {
        Usuarios updateUsuario = usuariosRepositorio.findById(id).
                orElseThrow(() -> new IllegalStateException("usuario No encontrado"));

        //Validaciones para actualizar los campos, si no es nulo, si hay caracteres y si no son iguales
        if (nombre != null && nombre.length() > 0 && !Objects.equals(updateUsuario.getNombre(), nombre)){
            updateUsuario.setNombre(nombre);
        }
        if (apellidos != null && apellidos.length() > 0 && !Objects.equals(updateUsuario.getApellidos(), apellidos)){
            updateUsuario.setApellidos(apellidos);
        }
        if (edad != null && edad.toString().length() > 0 && !Objects.equals(updateUsuario.getEdad(), edad)) {
            updateUsuario.setEdad(edad);
        }
        if (email != null && email.length() > 0 && !Objects.equals(updateUsuario.getEmail(), email)){
            Optional<Usuarios> usuariosOptional = usuariosRepositorio.findByUsuariosEmail(email);
            if(usuariosOptional.isPresent()){
                throw new IllegalStateException("El email ya esta registrado!");
            }
            updateUsuario.setEmail(email);
        }
        if (urlpicture != null && urlpicture.length() > 0 && !Objects.equals(updateUsuario.getUrlpicture(), urlpicture)){
            updateUsuario.setUrlpicture(urlpicture);
        }
        if (user != null && user.length() > 0 && !Objects.equals(updateUsuario.getUser(), user)){
            updateUsuario.setUser(user);
        }
        if (password != null && password.length() > 0 && !Objects.equals(updateUsuario.getPassword(), password)){
            updateUsuario.setPassword(password);
        }

    }

    public Optional<Usuarios> getUsuarioPorId(Long id) {
        return usuariosRepositorio.findById(id);
    }

//    public Optional<Usuarios> getUsuarioAndPassword(String user, String password) {
//        return usuariosRepositorio.findByUsuariosByuserNameAndPass(user, password);
//    }
    public Optional<Usuarios> getUsuarioAndPassword(String user, String password) {
        Optional<Usuarios> usuariosOptional = usuariosRepositorio.findByUsuariosByuserNameAndPass(user);
//        Usuarios checkUsuario = usuariosRepositorio.findByUsuariosByuserNameAndPass(user).
//                orElseThrow(() -> new IllegalStateException("usuario No encontrado"));
        if(usuariosOptional.isPresent()){
            if (password != null && password.length() > 0 && !Objects.equals(usuariosOptional.get().getPassword() , password)) {
                    throw new IllegalStateException("La contraseña no es correcta!");
                }
        }
        return usuariosRepositorio.findByUsuariosByuserNameAndPass(user);
    }
}
