package org.Nize.Models;

import javax.swing.text.DateFormatter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
    private Connection conn;

    public UserDAO() {
        this.conn = Conexion.getInstance().getConnection();
    }

    public int insertarUser(User user) {
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
        return getIdUsuario(user);
    }

    public User getUsuario(String dni){
        String sql = "SELECT * FROM usuarios WHERE dni = " + dni;
        User user = null;
        try(Statement statement = conn.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                user = new User(rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("email"));
                user.setFecha_Creacion(rs.getString("fecha_creacion"));
                user.setID_Usuario(rs.getInt("id_usuario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return user;
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




}
