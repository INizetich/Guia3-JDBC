package org.Nize.Models;

import java.sql.*;

public class CredencialesDAO {
    private Connection conn;

    public CredencialesDAO() {
        this.conn = Conexion.getInstance().getConnection();
    }


    public void crearCredenciales(User user, int id) {
        Credenciales credenciales = null;
        String iniciales = String.valueOf(user.getNombre().charAt(0)) + String.valueOf(user.getApellido().charAt(0));
        credenciales = new Credenciales(user.getID_Usuario(), iniciales + user.getDni(), "1234");
        String sql2 = "INSERT INTO credenciales(id_usuario,username,pass,permiso) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement2 = conn.prepareStatement(sql2)) {
            preparedStatement2.setInt(1, id);
            preparedStatement2.setString(2, credenciales.getUserName());
            preparedStatement2.setString(3, credenciales.getPassword());
            preparedStatement2.setString(4, credenciales.getPermisos().toString());
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int iniciarSesion(String user, String pass) {
        String sql = "SELECT * FROM credenciales WHERE username = ? AND pass = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                return rs.getInt("id_usuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean cambiarPass(String pass, int id_usuario){
        String sql = "UPDATE credenciales set pass = ? where id_usuario = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,pass);
            preparedStatement.setInt(2,id_usuario);
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarPass(String pass, int id_usuario){
        String sql = "SELECT * FROM credenciales WHERE pass = ? AND id_usuario = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, pass);
            preparedStatement.setInt(2, id_usuario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
