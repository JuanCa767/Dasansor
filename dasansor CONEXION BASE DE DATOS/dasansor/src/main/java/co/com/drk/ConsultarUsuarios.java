/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.drk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yherman.velasquez
 */
public class ConsultarUsuarios {
    
    public List<UsuarioDTO> consultarUsuarios() throws SQLException{
        
        ConnectionBD con = new ConnectionBD();
        List<UsuarioDTO> resultadoUsuarios = new ArrayList<>();
        PreparedStatement prepareStatement = con.conectarBd().prepareStatement("Select * from usuarios");

        
        ResultSet rs = prepareStatement.executeQuery();
    
        
        while(rs.next()){
            UsuarioDTO usuario = new UsuarioDTO();
            
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setEmail(rs.getString("email"));
            
            resultadoUsuarios.add(usuario);
        }
        con.conectarBd().close();
      return resultadoUsuarios;
}
}
