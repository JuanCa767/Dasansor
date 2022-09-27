/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.drk;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String args[]) throws SQLException {

        ConnectionBD conexion = new ConnectionBD();

        Connection conectarBd = conexion.conectarBd();
        if (conectarBd != null) {

            System.err.println("conexion ok " + conectarBd);
        }

        ConsultarUsuarios consultaUsuarios = new ConsultarUsuarios();
        List<UsuarioDTO> consultarUsuarios = consultaUsuarios.consultarUsuarios();

        for (UsuarioDTO user : consultarUsuarios) {

            System.out.println(user.toString());
        }

//        InsertarUsuarios insertaUsuario = new InsertarUsuarios();
//        int insertarUsuario = insertaUsuario.insertarUsuario(new UsuarioDTO(3456789,"Juan", "Cruz", "jhjahja"));
//        if (insertarUsuario == 1) {
//            System.out.println("Usuario insertado");
//        } else {
//            System.out.println("Usuario No insertado");
//        }

    }

}
