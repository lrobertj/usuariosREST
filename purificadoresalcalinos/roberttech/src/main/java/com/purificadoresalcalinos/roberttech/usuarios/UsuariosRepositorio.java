package com.purificadoresalcalinos.roberttech.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Data Access Layer
@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long> {

    //insertar si el email no existe
    @Query("SELECT u FROM Usuarios u WHERE u.email = ?1")
    Optional<Usuarios> findByUsuariosEmail(String email);

//    @Query("SELECT u FROM Usuarios u WHERE u.user = ?1 AND u.password = ?1")
//    Optional<Usuarios> findByUsuariosByuserNameAndPass(String user, String password);
    @Query("SELECT u FROM Usuarios u WHERE u.user = ?1")
    Optional<Usuarios> findByUsuariosByuserNameAndPass(String user);
}
