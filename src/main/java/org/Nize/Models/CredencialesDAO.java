package org.Nize.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CredencialesDAO {
    private Connection conn;

    public CredencialesDAO(){
        this.conn = Conexion.getInstance().getConnection();
    }


    public void crearCredenciales(User user, int id){
        Credenciales credenciales = null;
        String iniciales = String.valueOf(user.getNombre().charAt(0))+String.valueOf(user.getApellido().charAt(0));
        credenciales = new Credenciales(user.getID_Usuario(),iniciales+user.getDni(),"1234");
        String sql2 = "INSERT INTO credenciales(id_usuario,username,pass,permiso) VALUES (?,?,?,?)";

        try(PreparedStatement preparedStatement2 = conn.prepareStatement(sql2)){
            preparedStatement2.setInt(1, id);
            preparedStatement2.setString(2,credenciales.getUserName());
            preparedStatement2.setString(3,credenciales.getPassword());
            preparedStatement2.setString(4,credenciales.getPermisos().toString());
            preparedStatement2.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    public boolean iniciarSesion(String user, String contraseña){
//        String sql = "SELECT FROM USUARIOS "
//    }
}
