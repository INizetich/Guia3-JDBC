package org.Nize.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CuentaCorrienteDAO {
    private Connection connection;
    public CuentaCorrienteDAO(){
        connection = Conexion.getInstance().getConnection();
    }

    public void abrirCuentaCorriente(int id_usuario){
        String sql = "INSERT INTO cuentas(id_usuario,tipo,saldo,fecha_creacion) VALUES(?,?,?,?)";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_usuario);
            preparedStatement.setString(2,"CUENTA_CORRIENTE");
            preparedStatement.setDouble(3,0);
            preparedStatement.setString(4,fechaActual.format(formateador));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void abrirCajaAhorro(int id_usuario){
        String sql = "INSERT INTO cuentas(id_usuario,tipo,saldo,fecha_creacion) VALUES(?,?,?,?)";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_usuario);
            preparedStatement.setString(2,"CAJA_AHORRO");
            preparedStatement.setDouble(3,0);
            preparedStatement.setString(4,fechaActual.format(formateador));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public CuentaCorriente mostrarCajaAhorro(int id_usuario){
        String sql = "select * from cuentas where id_usuario=?";
        CuentaCorriente cuentaCorriente = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_usuario);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                cuentaCorriente = new CuentaCorriente(rs.getInt("id_cuenta"),rs.getInt("id_usuario"),rs.getDouble("saldo"),rs.getString("fecha_creacion"),rs.getString("tipo"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuentaCorriente;
    }


}
