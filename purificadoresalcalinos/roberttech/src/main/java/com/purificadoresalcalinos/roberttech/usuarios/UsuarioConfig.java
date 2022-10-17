package com.purificadoresalcalinos.roberttech.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

//Clase que utiliza el CommandLineRunner para insertar Usuario a la Base de datos
@Configuration
public class UsuarioConfig {
/*
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UsuarioConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
*/
    @Bean
    CommandLineRunner insertUsuariofromBean(UsuariosRepositorio usuariosRepositorio){
        return args -> {
//            Usuarios luciano = new Usuarios(
//                    "Luciano",
//                    "Robert",
//                    43,
//                    "lrobert@outlook.com"//,
//                    "https://lh3.googleusercontent.com/a-/ACNPEu-uluB5Czeli8yFUWt6mmot1LNSx6BspaiAxK202Q=s288-p-rw-no",
//                    "lrobert",
//                    "none"
//                    );
            Usuarios luciano = new Usuarios("", "", 0,"lrobertj@outlook.com","","lrobert", "password123");
            Usuarios amy = new Usuarios(
                    "Amy Estefania",
                    "Robert",
                    4,
                    "amyestefania@outlook.com",
                    "https://lh3.googleusercontent.com/a-/ACNPEu-uluB5Czeli8yFUWt6mmot1LNSx6BspaiAxK202Q=s288-p-rw-no",
                    "aerobert",
                    "password");
            usuariosRepositorio.saveAll(List.of(luciano, amy));
        };
    }
}
