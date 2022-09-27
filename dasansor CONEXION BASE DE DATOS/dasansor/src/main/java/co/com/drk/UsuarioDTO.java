/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.drk;

/**
 *
 * @author yherman.velasquez
 */
public class UsuarioDTO {
    
     private int id_usuario;
     private String nombre;
     private String  apellido;
     private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioDTO(int id_usuario, String nombre, String apellido, String email) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + '}';
    }
     
    
    
     
     
    
}
