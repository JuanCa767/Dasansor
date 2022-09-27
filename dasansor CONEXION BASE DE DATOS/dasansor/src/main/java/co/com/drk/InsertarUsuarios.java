/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.drk;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarUsuarios {
    
    public int insertarUsuario(UsuarioDTO usuario) throws SQLException{
    
            ConnectionBD con = new ConnectionBD();
        PreparedStatement ps = con.conectarBd().prepareStatement("insert into usuarios values (?,?,?,?)");
             ps.setInt(1, usuario.getId_usuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getEmail());
            con.conectarBd().close();
          return  ps.executeUpdate();

            
                                    
            
    
    }
    
}
