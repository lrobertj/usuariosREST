package com.purificadoresalcalinos.roberttech.usuarios;

import javax.persistence.*;

@Entity
//@Table(name="usuarios"//, uniqueConstraints = {
        //@UniqueConstraint(name="email_unique", columnNames = "email")//,
//        @UniqueConstraint(name="user_unique", columnNames = "user")
//}
//)
@Table
public class Usuarios {
    @Id
    @SequenceGenerator(
            name="usuarios_sequence",
            sequenceName = "usuarios_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuarios_sequence"
    )
    private Long id;
    //@Column(name="nombre", nullable = false, length = 50)
    private String nombre;
    private String apellidos;
    private Integer edad;
//    @Column(name="email", nullable = false)
    private String email;
    private String urlpicture;
    //@Column(name="user", nullable = false)
    private String user;
    private String password;

    //Constructores

    public Usuarios(String email) {
        this.email = email;
    }

    public Usuarios() {

    }

    public Usuarios(Long id, String nombre, String apellidos, int edad, String email, String urlpicture, String user,
                    String password) {

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.urlpicture = urlpicture;
        this.user = user;
        this.password = password;
    }

    public Usuarios(String nombre, String apellidos, int edad, String email, String urlpicture, String user,
                    String password) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.urlpicture = urlpicture;
        this.user = user;
        this.password = password;
    }

    //Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlpicture() {
        return urlpicture;
    }

    public void setUrlpicture(String urlpicture) {
        this.urlpicture = urlpicture;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString Method
    @Override
    public String toString() {
        return "Usuarios {id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", email="
                + email + ", urlpicture=" + urlpicture + ", user=" + user + ", password=" + password + "}";
    }

}
