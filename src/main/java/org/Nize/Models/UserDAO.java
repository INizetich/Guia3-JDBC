package org.Nize.Models;

import javax.swing.text.DateFormatter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDAO {
    private Connection conn;

    public UserDAO() {
        this.conn = Conexion.getConexion();
    }

    public void insertarUser(User user) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();
        String sql = "INSERT INTO usuarios(nombre,apellido,dni,email,fecha_creacion) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getApellido());
            preparedStatement.setString(3, user.getDni());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, fechaActual.format(formateador));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdUsuario(User user){
        String sql = "SELECT id_usuario FROM usuarios WHERE dni="+user.getDni();
        try(Statement statement = conn.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                return rs.getInt("id_usuario");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void crearCredenciales(User user){
        Credenciales credenciales = null;
        String iniciales = String.valueOf(user.getNombre().charAt(0))+String.valueOf(user.getApellido().charAt(0));
        credenciales = new Credenciales(user.getID_Usuario(),iniciales+user.getDni(),"1234");
        String sql2 = "INSERT INTO credenciales(id_usuario,username,pass,permiso) VALUES (?,?,?,?)";

        try(PreparedStatement preparedStatement2 = conn.prepareStatement(sql2)){
            preparedStatement2.setInt(1,getIdUsuario(user));
            preparedStatement2.setString(2,credenciales.getUserName());
            preparedStatement2.setString(3,credenciales.getPassword());
            preparedStatement2.setString(4,credenciales.getPermisos().toString());
            preparedStatement2.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
